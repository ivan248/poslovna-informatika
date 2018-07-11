package com.basic.project.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.basic.project.domain.Cenovnik;
import com.basic.project.domain.GrupaProizvoda;
import com.basic.project.domain.JedinicaMere;
import com.basic.project.domain.Proizvod;
import com.basic.project.domain.StavkaCenovnika;
import com.basic.project.repository.CenovnikRepository;
import com.basic.project.repository.GrupaProizvodaRepository;
import com.basic.project.repository.JedinicaMereRepository;
import com.basic.project.repository.ProizvodRepository;
import com.basic.project.repository.StavkaCenovnikaRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private ProizvodRepository proizvodRepository;
	
	@Autowired
	private JedinicaMereRepository jedinicaMereRepository;
	
	@Autowired
	private GrupaProizvodaRepository grupaProizvodaRepository;
	
	@Autowired CenovnikRepository cenovnikRepository;
	
	
	@Autowired StavkaCenovnikaRepository stavkaCenovnikaRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

//		insertIntoJedinicaMere();
//		insertIntoGrupaProizvoda();
//		insertIntoProizvod();
//		insertIntoCenovnik();
//		insertIntoStavkaCenovnika();
		
	}

	private void insertIntoGrupaProizvoda() {

		GrupaProizvoda gp = new GrupaProizvoda();
		
		gp.setNazivGrupeProizvoda("Psi");
		
		grupaProizvodaRepository.save(gp);
		
		GrupaProizvoda gp1 = new GrupaProizvoda();
		
		gp1.setNazivGrupeProizvoda("Cigle");
		
		grupaProizvodaRepository.save(gp1);
				
		GrupaProizvoda gp2 = new GrupaProizvoda();
		
		gp2.setNazivGrupeProizvoda("Daske");
		
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
		c.setDatumVazenja(new Date());
		
		cenovnikRepository.save(c);
		
		
	}
	
	private void insertIntoStavkaCenovnika() {
		StavkaCenovnika s = new StavkaCenovnika(1L,250L,proizvodRepository.findById(1L).get(), cenovnikRepository.findById(1L).get());
		StavkaCenovnika s2 = new StavkaCenovnika(2L,999L,proizvodRepository.findById(3L).get(), cenovnikRepository.findById(1L).get());
		StavkaCenovnika s3 = new StavkaCenovnika(3L,1799L,proizvodRepository.findById(2L).get(), cenovnikRepository.findById(1L).get());
		
		stavkaCenovnikaRepository.save(s);
		stavkaCenovnikaRepository.save(s2);
		stavkaCenovnikaRepository.save(s3);		
	}
	

}
