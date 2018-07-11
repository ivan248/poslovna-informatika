package com.basic.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.basic.project.domain.StavkaCenovnika;
@Service
public interface StavkaCenovnikaService {

	List<StavkaCenovnika> getAllStavkeCenovnika();

	boolean addStavkaCenovnika(StavkaCenovnika p);

	StavkaCenovnika getStavkaCenovnika(Long proizvodId);

	boolean updateStavkaCenovnika(StavkaCenovnika p);

	boolean deleteStavkaCenovnika(Long proizvodId);
}
