package com.basic.project.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.project.domain.StopaPDV;
import com.basic.project.repository.StopaPDVRepository;
import com.basic.project.service.StopaPDVService;

@Service
public class StopaPDVServiceImpl implements StopaPDVService{
	@Autowired
	private StopaPDVRepository repository;

	@Override
	public List<StopaPDV> getAll() {
		return repository.findAll();
	}

	@Override
	public boolean add(StopaPDV p) {
		try {
			repository.save(p);	
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public StopaPDV getOne(Long id) {
		try {
			return repository.findById(id).get();
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean update(StopaPDV p) {
		try {
			
			repository.save(p);
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
