package com.basic.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.basic.project.domain.Narudzbenica;

@Service
public interface NarudzbenicaService {

	List<Narudzbenica> getAll();

	Narudzbenica getOne(Long id);

	boolean add(Narudzbenica n);

	boolean update(Narudzbenica n);

	boolean delete(Long id);

}
