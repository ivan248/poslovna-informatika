package com.basic.project.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.project.domain.Cenovnik;
import com.basic.project.repository.CenovnikRepository;
import com.basic.project.service.CenovnikService;

@Service
public class CenovnikServiceImpl implements CenovnikService {
	@Autowired
	private CenovnikRepository repository;

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
		try {
			return repository.findById(id).get();
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
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

}
