package com.basic.project.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.project.domain.PoslovniPartner;
import com.basic.project.repository.PoslovniPartnerRepository;
import com.basic.project.service.PoslovniPartnerService;

@Service
public class PoslovniPartnerServiceImpl implements PoslovniPartnerService {

	@Autowired
	private PoslovniPartnerRepository poslovniPartnerRepository;
	
	@Override
	public List<PoslovniPartner> getAll() {
		try {
			return poslovniPartnerRepository.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

}
