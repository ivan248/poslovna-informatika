package com.basic.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.basic.project.domain.Narudzbenica;

@Service
public interface NarudzbenicaService {

	List<Narudzbenica> getAll();

	Narudzbenica getOne(Long id);

	boolean add(Narudzbenica n, Map<Long, Integer> map);

	boolean update(Narudzbenica n, Map<Long, Integer> map);

	boolean delete(Long id);

}
