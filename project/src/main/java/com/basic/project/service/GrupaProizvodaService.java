package com.basic.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.basic.project.domain.GrupaProizvoda;

@Service
public interface GrupaProizvodaService {

	List<GrupaProizvoda> getAll();

	boolean add(GrupaProizvoda g);

	GrupaProizvoda getOne(Long id);

	boolean update(GrupaProizvoda g);

	boolean delete(Long id);
}
