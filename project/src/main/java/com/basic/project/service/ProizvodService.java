package com.basic.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.basic.project.domain.Proizvod;

@Service
public interface ProizvodService {

	List<Proizvod> getAllProizvod();

	boolean addProizvod(Proizvod p);

	Proizvod getProizvod(Long proizvodId);

	boolean updateProizvod(Proizvod p);

	boolean deleteProizvod(Long proizvodId);

}
