package com.basic.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.basic.project.domain.Narudzbenica;
import com.basic.project.web.dto.ListaStavkiHelperObject;

@Service
public interface NarudzbenicaService {

	List<Narudzbenica> getAll();

	Narudzbenica getOne(Long id);

	boolean add(Narudzbenica n, List<ListaStavkiHelperObject> listaStavkiHelper);

	boolean update(Narudzbenica n, List<ListaStavkiHelperObject> listaStavkiHelper);

	boolean delete(Long id);

}
