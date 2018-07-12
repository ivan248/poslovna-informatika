package com.basic.project.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.project.domain.GrupaProizvoda;
import com.basic.project.repository.GrupaProizvodaRepository;
import com.basic.project.service.GrupaProizvodaService;

@Service
public class GrupaProizvodaServiceImpl implements GrupaProizvodaService {
	@Autowired
	private GrupaProizvodaRepository repository;
	
	@Override
	public List<GrupaProizvoda> getAll() {
		return repository.findAll();
	}

	@Override
	public boolean add(GrupaProizvoda g) {
		try {
			repository.save(g);	
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public GrupaProizvoda getOne(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public boolean update(GrupaProizvoda g) {
		try {
			repository.save(g);
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
