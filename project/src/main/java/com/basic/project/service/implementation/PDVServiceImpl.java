package com.basic.project.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.project.domain.PDV;
import com.basic.project.repository.PDVRepository;
import com.basic.project.service.PDVService;

@Service
public class PDVServiceImpl implements PDVService{
	
	@Autowired
	private PDVRepository repository;

	@Override
	public List<PDV> getAll() {
		return repository.findAll();
	}

	@Override
	public boolean add(PDV g) {
		try {
			repository.save(g);	
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PDV getOne(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public boolean update(PDV g) {
		try {
			PDV c = repository.findById(g.getId()).get();
			c.setNaziv(g.getNaziv());
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
