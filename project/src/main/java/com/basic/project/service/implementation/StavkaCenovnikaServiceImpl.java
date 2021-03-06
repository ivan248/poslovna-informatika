package com.basic.project.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.project.domain.StavkaCenovnika;
import com.basic.project.repository.CenovnikRepository;
import com.basic.project.repository.StavkaCenovnikaRepository;
import com.basic.project.service.StavkaCenovnikaService;
@Service
public class StavkaCenovnikaServiceImpl implements StavkaCenovnikaService {
	
	@Autowired
	private CenovnikRepository cenovnikRepository;
	
	@Autowired
	private StavkaCenovnikaRepository repository;

	@Override
	public List<com.basic.project.domain.StavkaCenovnika> getAllStavkeCenovnika() {
		return repository.findAll();
	}

	@Override
	public boolean addStavkaCenovnika(StavkaCenovnika p) {
		try {
			
			for(StavkaCenovnika stavkaCenovnika:cenovnikRepository.findById(p.getCenovnik().getId()).get().getStavke())
			{
				if(stavkaCenovnika.getProizvod().getId() == p.getProizvod().getId())
				{
					System.out.println("Zabranjeno dodavanje. Postoji vec proizvod u cenovniku!");
					return false;
				}
			}
			
			repository.save(p);	
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public StavkaCenovnika getStavkaCenovnika(Long id) {
	
		try {
			return repository.findById(id).get();
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateStavkaCenovnika(com.basic.project.domain.StavkaCenovnika p) {
		try {
			repository.save(p);	
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteStavkaCenovnika(Long id) {
		try {
			repository.deleteById(id);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
