package com.basic.project.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.basic.project.domain.Adresa;
import com.basic.project.domain.Cenovnik;
import com.basic.project.domain.GrupaProizvoda;
import com.basic.project.domain.JedinicaMere;
import com.basic.project.domain.Narudzbenica;
import com.basic.project.domain.PDV;
import com.basic.project.domain.PoslovniPartner;
import com.basic.project.domain.PoslovniPartnerVrsta;
import com.basic.project.domain.Proizvod;
import com.basic.project.domain.StavkaCenovnika;
import com.basic.project.domain.StopaPDV;
import com.basic.project.repository.AdresaRepository;
import com.basic.project.repository.CenovnikRepository;
import com.basic.project.repository.GrupaProizvodaRepository;
import com.basic.project.repository.JedinicaMereRepository;
import com.basic.project.repository.NarudzbenicaRepository;
import com.basic.project.repository.PDVRepository;
import com.basic.project.repository.PoslovniPartnerRepository;
import com.basic.project.repository.ProizvodRepository;
import com.basic.project.repository.StavkaCenovnikaRepository;
import com.basic.project.repository.StopaPDVRepository;

@Component
@SuppressWarnings("unused")
public class DataLoader implements ApplicationRunner {

	@Autowired
	private ProizvodRepository proizvodRepository;
	
	@Autowired
	private JedinicaMereRepository jedinicaMereRepository;
	
	@Autowired
	private GrupaProizvodaRepository grupaProizvodaRepository;
	
	@Autowired 
	private CenovnikRepository cenovnikRepository;
	
	@Autowired 
	private StavkaCenovnikaRepository stavkaCenovnikaRepository;
	
	@Autowired 
	private PDVRepository pdvRepository;
	
	@Autowired
	private PoslovniPartnerRepository poslovniPartnerRepository;
	
	@Autowired
	private NarudzbenicaRepository narudzbenicaRepository;
	
	@Autowired
	private AdresaRepository adresaRepository;
	
	@Autowired
	private StopaPDVRepository stopaPDVRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
//		insertIntoPDV();
//		insertIntoJedinicaMere();
//		insertIntoGrupaProizvoda();
//		insertIntoProizvod();
//		insertIntoCenovnik();
//		insertIntoStavkaCenovnika();
//		insertIntoAdresa();
//		insertIntoPoslovniPartner();
//		insertIntoNarudzbenica();
//		insertIntoStopaPDV();
	}
	
	private void insertIntoAdresa() {

		Adresa a = new Adresa();
		
		a.setBrojUlice(75);
		a.setGrad("Smederevo");
		a.setPostanskiBroj(11300);
		a.setUlica("Kosovska");
		
		adresaRepository.save(a);
		
		Adresa a1 = new Adresa();
		
		
		a1.setBrojUlice(30);
		a1.setGrad("Zrenjanin");
		a1.setPostanskiBroj(21000);
		a1.setUlica("Fikina ulica snova");
		
		adresaRepository.save(a1);
		
	}

	private void insertIntoPoslovniPartner() {
		
		PoslovniPartner p = new PoslovniPartner();
		
		p.setAdresaPreduzeca(adresaRepository.getOne(1L));
		p.setEmailPreduzeca("radnja@email.com");
		p.setNazivPreduzeca("Preduzece 1");
		p.setPibPreduzeca(1234);
		p.setTelefonPreduzeca(026555555);
		p.setPoslovniPartnerVrsta(PoslovniPartnerVrsta.FIZICKO_LICE);
		
		poslovniPartnerRepository.save(p);
		
	}

	private void insertIntoNarudzbenica() {
		
		Narudzbenica n = new Narudzbenica();
		
		n.setPoslovniPartner(poslovniPartnerRepository.getOne(1L));
		
		Map<Proizvod, Integer> listaStavki = new HashMap<Proizvod, Integer>();
		
		listaStavki.put(proizvodRepository.getOne(1L), 5);
		listaStavki.put(proizvodRepository.getOne(2L), 20);
		
		n.setListaStavki(listaStavki);
		
		narudzbenicaRepository.save(n);
		
		Narudzbenica n1 = new Narudzbenica();
		
		n1.setPoslovniPartner(poslovniPartnerRepository.getOne(1L));
		
		Map<Proizvod, Integer> listaStavki1 = new HashMap<Proizvod, Integer>();
		
		listaStavki1.put(proizvodRepository.getOne(1L), 10);
		listaStavki1.put(proizvodRepository.getOne(2L), 4);
		
		n1.setListaStavki(listaStavki1);
		
		narudzbenicaRepository.save(n1);
	}

	private void insertIntoPDV() {
		PDV p = new PDV();
		p.setNaziv("Zivotinje");
		
		PDV p2 = new PDV();
		p2.setNaziv("Gradjevinski materijal");
		
		PDV p3 = new PDV();
		p3.setNaziv("Proizvodi od drveta");
		
		pdvRepository.save(p);
		pdvRepository.save(p2);
		pdvRepository.save(p3);
	}	

	private void insertIntoGrupaProizvoda() {

		GrupaProizvoda gp = new GrupaProizvoda();
		
		gp.setNazivGrupeProizvoda("Psi");
		gp.setPdv(pdvRepository.getOne(1L));
		
		grupaProizvodaRepository.save(gp);
		
		GrupaProizvoda gp1 = new GrupaProizvoda();
		
		gp1.setNazivGrupeProizvoda("Cigle");
		gp1.setPdv(pdvRepository.getOne(2L));
		
		grupaProizvodaRepository.save(gp1);
				
		GrupaProizvoda gp2 = new GrupaProizvoda();
		
		gp2.setNazivGrupeProizvoda("Daske");
		gp2.setPdv(pdvRepository.getOne(3L));
		grupaProizvodaRepository.save(gp2);
		
	}

	private void insertIntoJedinicaMere() {
		
		JedinicaMere jm = new JedinicaMere();
		jm.setNazivJediniceMere("Brojno stanje");
		jm.setSkracenica("br");
		
		jedinicaMereRepository.save(jm);
		
		JedinicaMere jm1 = new JedinicaMere();
		jm1.setNazivJediniceMere("Tezina");
		jm1.setSkracenica("kg");
		
		jedinicaMereRepository.save(jm1);
		
		JedinicaMere jm2 = new JedinicaMere();
		jm2.setNazivJediniceMere("Duzina");
		jm2.setSkracenica("m");
		
		jedinicaMereRepository.save(jm2);
		
	}

	private void insertIntoProizvod() {
		
		Proizvod p = new Proizvod();
		
		p.setNazivProizvoda("Sibirski Malamut");
		p.setVrstaProizvoda("Zivotinja");
		
		p.setJedinicaMere(jedinicaMereRepository.findOneByNazivJediniceMere("Brojno stanje"));
		p.setGrupaProizvoda(grupaProizvodaRepository.findOneByNazivGrupeProizvoda("Psi"));
		
		proizvodRepository.save(p);
		
		Proizvod p1 = new Proizvod();
		
		p1.setNazivProizvoda("Crvena cigla");
		p1.setVrstaProizvoda("Gradjevinski materijal");
		
		p1.setJedinicaMere(jedinicaMereRepository.findOneByNazivJediniceMere("Tezina"));
		p1.setGrupaProizvoda(grupaProizvodaRepository.findOneByNazivGrupeProizvoda("Cigle"));
		
		proizvodRepository.save(p1);
		
		Proizvod p2 = new Proizvod();
		
		p2.setNazivProizvoda("Velika daska");
		p2.setVrstaProizvoda("Drveni proizvod");
		
		p2.setJedinicaMere(jedinicaMereRepository.findOneByNazivJediniceMere("Duzina"));
		p2.setGrupaProizvoda(grupaProizvodaRepository.findOneByNazivGrupeProizvoda("Daske"));
		
		proizvodRepository.save(p2);
		
	}
	
	private void insertIntoCenovnik() {
		Cenovnik c = new Cenovnik();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date d = null;
		try {
			d = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setDatumVazenja(d);
		
		cenovnikRepository.save(c);
		
		Cenovnik cc = new Cenovnik();
		
		try {
			d = sdf.parse("13-09-2018");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cc.setDatumVazenja(d);
		
		cenovnikRepository.save(cc);
		
	}
	
	private void insertIntoStavkaCenovnika() {
		StavkaCenovnika s = new StavkaCenovnika(1L,250L,proizvodRepository.findById(1L).get(), cenovnikRepository.findById(1L).get());
		StavkaCenovnika s2 = new StavkaCenovnika(2L,999L,proizvodRepository.findById(3L).get(), cenovnikRepository.findById(1L).get());
		StavkaCenovnika s3 = new StavkaCenovnika(3L,1799L,proizvodRepository.findById(2L).get(), cenovnikRepository.findById(1L).get());
		
		stavkaCenovnikaRepository.save(s);
		stavkaCenovnikaRepository.save(s2);
		stavkaCenovnikaRepository.save(s3);		
	}
	
	private void insertIntoStopaPDV() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date d = null;
		
		StopaPDV s = new StopaPDV();
		s.setId(1L);
		s.setStopa((float)0.1);
		s.setPdv(pdvRepository.getOne(1L));
		try {
			s.setDatumVazenja(d = sdf.parse("13-09-2018"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		StopaPDV s1 = new StopaPDV();
		s1.setId(2L);
		s1.setStopa((float)0.2);
		s1.setPdv(pdvRepository.getOne(2L));
		try {
			s1.setDatumVazenja(d = sdf.parse("21-12-2018"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		StopaPDV s2 = new StopaPDV();
		s2.setId(3L);
		s2.setStopa((float)0.5);
		s2.setPdv(pdvRepository.getOne(1L));
		try {
			s2.setDatumVazenja(d = sdf.parse("12-12-2021"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		stopaPDVRepository.save(s);
		stopaPDVRepository.save(s1);
		stopaPDVRepository.save(s2);
		
	}
	

}
