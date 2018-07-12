package com.basic.project.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.project.domain.Cenovnik;
import com.basic.project.domain.GrupaProizvoda;
import com.basic.project.domain.JedinicaMere;
import com.basic.project.domain.Proizvod;
import com.basic.project.repository.GrupaProizvodaRepository;
import com.basic.project.repository.JedinicaMereRepository;
import com.basic.project.repository.ProizvodRepository;
import com.basic.project.service.ProizvodService;

@Service
public class ProizvodServiceImpl implements ProizvodService {

	@Autowired
	private ProizvodRepository proizvodRepository;

	@Autowired
	private JedinicaMereRepository jedinicaMereRepository;

	@Autowired
	private GrupaProizvodaRepository grupaProizvodaRepository;

	@Override
	public List<Proizvod> getAllProizvod() {

		return proizvodRepository.findAll();
	}

	@Override
	public boolean addProizvod(Proizvod p) {

		try {

			if (jedinicaMereRepository.findOneByNazivJediniceMere(p.getJedinicaMere().getNazivJediniceMere()) != null) {
				p.setJedinicaMere(
						jedinicaMereRepository.findOneByNazivJediniceMere(p.getJedinicaMere().getNazivJediniceMere()));
			} else {
				JedinicaMere jm = new JedinicaMere();

				jm.setNazivJediniceMere(p.getJedinicaMere().getNazivJediniceMere());
				jm.setSkracenica(p.getJedinicaMere().getSkracenica());

				jedinicaMereRepository.save(jm);

				p.setJedinicaMere(
						jedinicaMereRepository.findOneByNazivJediniceMere(p.getJedinicaMere().getNazivJediniceMere()));
			}

			if (grupaProizvodaRepository
					.findOneByNazivGrupeProizvoda(p.getGrupaProizvoda().getNazivGrupeProizvoda()) != null) {
				p.setGrupaProizvoda(grupaProizvodaRepository
						.findOneByNazivGrupeProizvoda(p.getGrupaProizvoda().getNazivGrupeProizvoda()));
			} else {
				GrupaProizvoda gp = new GrupaProizvoda();

				gp.setNazivGrupeProizvoda(p.getGrupaProizvoda().getNazivGrupeProizvoda());

				grupaProizvodaRepository.save(gp);

				p.setGrupaProizvoda(grupaProizvodaRepository
						.findOneByNazivGrupeProizvoda(p.getGrupaProizvoda().getNazivGrupeProizvoda()));
			}

			proizvodRepository.save(p);
			return true;
		} catch (Exception e) {
			System.out.println("***********************ERROR IN ADD PROIZVOD***********************");
			e.printStackTrace();
			System.out.println("***********************ERROR IN ADD PROIZVOD***********************");
		}

		return false;
	}

	@Override
	public Proizvod getProizvod(Long proizvodId) {

		try {
			return proizvodRepository.findById(proizvodId).get();
		} catch (Exception e) {
			System.out.println("***********************ERROR IN GET ONE PROIZVOD***********************");
			e.printStackTrace();
			System.out.println("***********************ERROR IN GET ONE PROIZVOD***********************");
		}

		return null;

	}

	@Override
	public boolean updateProizvod(Proizvod p) {

		try {
			Proizvod c = proizvodRepository.findById(p.getId()).get();
			c.setNazivProizvoda(p.getNazivProizvoda());
			c.setVrstaProizvoda(p.getVrstaProizvoda());
			c.setGrupaProizvoda(p.getGrupaProizvoda());
			c.setJedinicaMere(p.getJedinicaMere());
			proizvodRepository.saveAndFlush(c);
			
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	
	}

	@Override
	public boolean deleteProizvod(Long proizvodId) {
		
		try {
			proizvodRepository.deleteById(proizvodId);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("***********************ERROR IN DELETE PROIZVOD***********************");
			e.printStackTrace();
			System.out.println("***********************ERROR IN DELETE PROIZVOD***********************");

		}
		
		
		return false;
	}

}
