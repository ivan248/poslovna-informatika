package com.basic.project.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.project.domain.Cenovnik;
import com.basic.project.domain.StavkaCenovnika;
import com.basic.project.repository.CenovnikRepository;
import com.basic.project.repository.StavkaCenovnikaRepository;
import com.basic.project.service.CenovnikService;

@Service
public class CenovnikServiceImpl implements CenovnikService {
	@Autowired
	private CenovnikRepository repository;
	
	@Autowired
	private StavkaCenovnikaRepository stavkaRepository;

	@Override
	public List<Cenovnik> getAll() {
		return repository.findAll();
	}

	@Override
	public boolean add(Cenovnik p) {
		try {
			repository.save(p);	
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Cenovnik getOne(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public boolean update(Cenovnik p) {
		try {
			Cenovnik c = repository.findById(p.getId()).get();
			c.setDatumVazenja(p.getDatumVazenja());
			repository.saveAndFlush(c);
			
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Long id) {
		try {
			repository.deleteById(id);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean copy(Cenovnik c, Long id, double promenaCene) {
		repository.save(c);
		//ubaciti novi cenovnik u bazu
		
		//prekopirati sve stavke koje su vezane za parent cenovnik
		try {
			List<StavkaCenovnika> listaStavki = stavkaRepository.findAll();
			for (StavkaCenovnika s : listaStavki) {
				if (s.getCenovnik().getId() == id) {
					StavkaCenovnika novaStavka = new StavkaCenovnika();
					novaStavka.setCena(  (s.getCena() * (promenaCene/100.0)));
					novaStavka.setCenovnik(c);
					novaStavka.setProizvod(s.getProizvod());
					stavkaRepository.save(novaStavka);
				}
			}
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
