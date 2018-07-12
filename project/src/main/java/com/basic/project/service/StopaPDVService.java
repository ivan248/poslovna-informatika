package com.basic.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.basic.project.domain.StopaPDV;


@Service
public interface StopaPDVService {

	List<StopaPDV> getAll();

	boolean add(StopaPDV p);

	StopaPDV getOne(Long id);

	boolean update(StopaPDV p);

	boolean delete(Long id);
}
