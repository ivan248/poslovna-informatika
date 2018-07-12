package com.basic.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.basic.project.domain.Cenovnik;

@Service
public interface CenovnikService {
	List<Cenovnik> getAll();

	boolean add(Cenovnik p);

	Cenovnik getOne(Long id);

	boolean update(Cenovnik p);

	boolean delete(Long id);
}
