package com.basic.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.basic.project.domain.Faktura;
import com.basic.project.domain.Narudzbenica;
import com.basic.project.web.dto.ListaStavkiHelperObject;

@Service
public interface FakturaService {

	List<Faktura> getAll();

	Faktura getFaktura(Long fakturaId);

	boolean delete(Long id);

	boolean add(Narudzbenica narudzbenica, List<ListaStavkiHelperObject> listaStavki);

	boolean export(Long fakturaId);
}
