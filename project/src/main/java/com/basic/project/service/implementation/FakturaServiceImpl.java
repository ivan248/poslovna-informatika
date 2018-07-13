package com.basic.project.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.project.domain.Faktura;
import com.basic.project.repository.FakturaRepository;
import com.basic.project.service.FakturaService;

@Service
public class FakturaServiceImpl implements FakturaService {

	@Autowired
	private FakturaRepository fakturaRepository;
	
	@Override
	public List<Faktura> getAll() {
		
		try {
			
			return fakturaRepository.findAll();
			
		} catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Faktura getFaktura(Long fakturaId) {

		try {
			
			return fakturaRepository.findById(fakturaId).get();
			
		} catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
