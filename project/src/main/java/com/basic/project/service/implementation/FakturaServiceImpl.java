package com.basic.project.service.implementation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

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
import com.basic.project.repository.StavkaFaktureRepository;
import com.basic.project.repository.StopaPDVRepository;
import com.basic.project.service.FakturaService;
import com.basic.project.web.dto.Converter;
import com.basic.project.web.dto.FakturaDTO;
import com.basic.project.web.dto.ListaStavkiHelperObject;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

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
	
	@Autowired
	private StavkaFaktureRepository stavkaFaktureRepository;	

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
			
			
			f.setDatumFakture(new Date(Calendar.getInstance().getTime().getTime()));
			f.setDatumValute(new Date(Calendar.getInstance().getTime().getTime()));
			
			f.setBrojFakture("FAKTURA_BROJ_" + (int)(Math.random()*1000));
			f.setPoslovnaGodina(poslovnaGodinaRepository.getOne(1L));
			
			fakturaRepository.save(f);
			
			List<Faktura> listaFaktura = new ArrayList<Faktura>(fakturaRepository.findAll());
			
			f = listaFaktura.get(listaFaktura.size()-1);
			
			List<StavkaFakture> stavkeFakture = new ArrayList<StavkaFakture>();
			
			for (Map.Entry<Proizvod, Integer> stavka : n.getListaStavki().entrySet())
			{
				StavkaFakture sf = new StavkaFakture();

				sf.setFaktura(f);
				
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
						//System.out.println(sc);
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
				
				stavkaFaktureRepository.save(sf);
				
				List<StavkaFakture> listaIzBaze = new ArrayList<StavkaFakture>(stavkaFaktureRepository.findAll());
				
				stavkeFakture.add(listaIzBaze.get(listaIzBaze.size()-1));
			
			}
			
			f.setStavkeFakture(stavkeFakture);
			
			for(StavkaFakture sf:stavkeFakture)
			{
				f.setUkupanPDV(f.getUkupanPDV() + sf.getIznosPDV());
				f.setUkupanRabat(f.getUkupanRabat() + ((sf.getJedinicnaCena()*sf.getKolicina())*sf.getRabat()));
				f.setUkupanIznosBezPDV(f.getUkupanIznosBezPDV() + sf.getOsnovica());
				f.setUkupnoZaPlacanje(f.getUkupnoZaPlacanje() + sf.getUkupanIznos());

			}
			

			fakturaRepository.save(f);
			
			//System.out.println(f);
			
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean export(Long fakturaId) {
			
		try {
			Faktura fakturaIzBaze = fakturaRepository.findById(fakturaId).get();
			FakturaDTO fakturaZaExport = Converter.convertFakturaToFakturaDTO(fakturaIzBaze);
			
			File file = new File("exportovanaFaktura" + fakturaId + ".xml");
			JAXBContext jaxbContext;
			
			jaxbContext = JAXBContext.newInstance(FakturaDTO.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			jaxbMarshaller.marshal(fakturaZaExport, file);
			
			//****************************** PDF
			
			List<StavkaFakture> listaStavki = fakturaIzBaze.getStavkeFakture();
			
			JRBeanCollectionDataSource itemsJRBean1 = new JRBeanCollectionDataSource(listaStavki);

			Map<String, Object> parameters1 = new HashMap<String, Object>();
			parameters1.put("ItemDataSource", itemsJRBean1);
			parameters1.put("BrojFakture", fakturaIzBaze.getBrojFakture());
			parameters1.put("DatumFakture", fakturaIzBaze.getDatumFakture());
			parameters1.put("IznosBezPDV", fakturaIzBaze.getUkupanIznosBezPDV());
			parameters1.put("UkupanPDV", fakturaIzBaze.getUkupanPDV());
			parameters1.put("UkupanRabat", fakturaIzBaze.getUkupanRabat());
			parameters1.put("UkupnoZaPlacanje", fakturaIzBaze.getUkupnoZaPlacanje());
			
			JasperPrint jasperPrint1 = JasperFillManager.fillReport("fakturaSaStavkama.jasper", parameters1, new JREmptyDataSource());
		    File pdfFile = new File("FakturaIzvestaj.pdf");
		    OutputStream outputStream1 = new FileOutputStream(pdfFile);
		    JasperExportManager.exportReportToPdfStream(jasperPrint1, outputStream1);
		    
		    outputStream1.close();
			
			//****************************** PDF
			
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<Faktura> getKif(Date datumOd, Date datumDo) {
		try {
			List<Faktura> listaFaktura = new ArrayList<Faktura>();
			
			for(Faktura f:fakturaRepository.findAll())
			{
				if(datumOd.before(f.getDatumFakture()) && datumDo.after(f.getDatumFakture()))
				{
					System.out.println("Datum od: " + datumOd);
					System.out.println("Datum moje fakture: " + f.getDatumFakture());
					System.out.println("Datum do: " + datumDo);
					listaFaktura.add(f);
				}
					
			}
				
			return listaFaktura;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
