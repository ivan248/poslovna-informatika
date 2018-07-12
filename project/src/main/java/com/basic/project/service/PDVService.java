package com.basic.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.basic.project.domain.PDV;


@Service		
public interface PDVService {
	List<PDV> getAll();

	boolean add(PDV g);

	PDV getOne(Long id);

	boolean update(PDV g);

	boolean delete(Long id);
}
