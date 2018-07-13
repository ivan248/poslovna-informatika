package com.basic.project.service.implementation;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.project.domain.Faktura;
import com.basic.project.domain.Narudzbenica;
import com.basic.project.domain.Proizvod;
import com.basic.project.domain.StavkaCenovnika;
import com.basic.project.domain.StavkaFakture;
import com.basic.project.repository.CenovnikRepository;
import com.basic.project.repository.FakturaRepository;
import com.basic.project.repository.PoslovnaGodinaRepository;
import com.basic.project.repository.ProizvodRepository;
import com.basic.project.repository.StopaPDVRepository;
import com.basic.project.service.FakturaService;
import com.basic.project.web.dto.ListaStavkiHelperObject;

@Service
public class FakturaServiceImpl implements FakturaService {

	@Autowired
	private FakturaRepository fakturaRepository;
	
	@Autowired
	private ProizvodRepository proizvodRepository;
	
	@Autowired
	private CenovnikRepository cenovnikRepository;
	
	@Autowired
	private StopaPDVRepository stopaPDVRepository;
	
	@Autowired
	private PoslovnaGodinaRepository poslovnaGodinaRepository;

	@Override
	public List<Faktura> getAll() {

		try {

			return fakturaRepository.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Faktura getFaktura(Long fakturaId) {

		try {

			return fakturaRepository.findById(fakturaId).get();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(Long id) {

		try {

			fakturaRepository.deleteById(id);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean add(Narudzbenica n, List<ListaStavkiHelperObject> listaStavkiHelper) {

		try {

			Map<Proizvod, Integer> listaStavki = new HashMap<Proizvod, Integer>();

			for (ListaStavkiHelperObject ls : listaStavkiHelper) {
				// dobijam -> proizvod : kolicina sa fronta i onda ako je kolicina > 0 onda moze
				// da se ubaci
				if (ls.getKolicina() > 0)
					listaStavki.put(proizvodRepository.getOne(ls.getId()), ls.getKolicina());
			}

			n.setListaStavki(listaStavki);

			Faktura f = new Faktura();
			
			List<StavkaFakture> stavkeFakture = new ArrayList<StavkaFakture>();
			
			for (Map.Entry<Proizvod, Integer> stavka : n.getListaStavki().entrySet())
			{
				StavkaFakture sf = new StavkaFakture();
				
				// KOLICINA
				sf.setKolicina(stavka.getValue());
				
				// PROIZVOD
				sf.setProizvod(stavka.getKey());
				
				// RABAT
				sf.setRabat(0.1);
				
				// CENA
				for(StavkaCenovnika sc:cenovnikRepository.findByAktivan(true).getStavke())
				{
					if(sc.getProizvod().getId() == sf.getProizvod().getId())
					{
						System.out.println("Pronasao proizvod za aktuelni cenovnik!");
						System.out.println(sc);
						sf.setJedinicnaCena(sc.getCena());
						break;
					}
				}
				
				// STOPA PDV
				sf.setStopaPDV(stopaPDVRepository.findById(sf.getProizvod().getGrupaProizvoda().getPdv().getId()).get().getStopa());
			
				// OSNOVICA
				double osnovica = (sf.getJedinicnaCena()*sf.getKolicina()) - ((sf.getJedinicnaCena()*sf.getKolicina())*sf.getRabat());
				sf.setOsnovica(osnovica);
				
				// IZNOS PDV-a
				double iznosPdv = ( sf.getOsnovica() * (1+sf.getStopaPDV()) ) - sf.getOsnovica();
				sf.setIznosPDV(iznosPdv);
				
				sf.setUkupanIznos(sf.getOsnovica()+sf.getIznosPDV());
				
				stavkeFakture.add(sf);
			
			}
			
			f.setStavkeFakture(stavkeFakture);
			
			for(StavkaFakture sf:stavkeFakture)
			{
				f.setUkupanPDV(f.getUkupanPDV() + sf.getIznosPDV());
				f.setUkupanRabat(f.getUkupanRabat() + ((sf.getJedinicnaCena()*sf.getKolicina())*sf.getRabat()));
				f.setUkupanIznosBezPDV(f.getUkupanIznosBezPDV() + sf.getOsnovica());
				f.setUkupnoZaPlacanje(f.getUkupnoZaPlacanje() + sf.getUkupanIznos());

			}
			
			
			f.setDatumFakture(new Date(Calendar.getInstance().getTime().getTime()));
			f.setDatumValute(new Date(Calendar.getInstance().getTime().getTime()));
			
			f.setBrojFakture("FAKTURA_BROJ_" + (Math.random()*10));
			f.setPoslovnaGodina(poslovnaGodinaRepository.getOne(1L));
			fakturaRepository.save(f);
			
			System.out.println(f);
			
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

}
