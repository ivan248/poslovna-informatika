package com.basic.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.basic.project.domain.JedinicaMere;

@Service
public interface JedinicaMereService {

	List<JedinicaMere> getAll();

	boolean add(JedinicaMere jm);

	JedinicaMere getOne(Long id);

	boolean update(JedinicaMere jm);

	boolean delete(Long id);
	
}
