package com.basic.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.basic.project.domain.Faktura;

@Service
public interface FakturaService {

	List<Faktura> getAll();

	Faktura getFaktura(Long fakturaId);
}
