package com.basic.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.basic.project.domain.StavkaCenovnika;
@Service
public interface StavkaCenovnikaService {

	List<StavkaCenovnika> getAllStavkeCenovnika();

	boolean addStavkaCenovnika(StavkaCenovnika g);

	StavkaCenovnika getStavkaCenovnika(Long id);

	boolean updateStavkaCenovnika(StavkaCenovnika g);

	boolean deleteStavkaCenovnika(Long id);
}
