package com.basic.project.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.project.domain.GrupaProizvoda;
import com.basic.project.domain.Proizvod;
import com.basic.project.repository.GrupaProizvodaRepository;
import com.basic.project.repository.ProizvodRepository;
import com.basic.project.service.GrupaProizvodaService;

@Service
public class GrupaProizvodaServiceImpl implements GrupaProizvodaService {
	
	@Autowired
	private GrupaProizvodaRepository repository;
	
	@Autowired
	private ProizvodRepository proizvodRepository;
	
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
		try {
			return repository.findById(id).get();
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
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
			
			for(Proizvod p:proizvodRepository.findAll())
			{
				if(p.getGrupaProizvoda().getId() == id)
				{
					System.out.println("************************** WARNING **************************\n\n");
					System.out.println("Ne mozete obrisati ovu grupu proizvoda. Postoji proizvod koji je sadrzi!\n\n");
					System.out.println("************************** WARNING **************************");
					return false;
				}
			}
			
			repository.deleteById(id);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
