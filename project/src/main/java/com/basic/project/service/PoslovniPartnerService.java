package com.basic.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.basic.project.domain.PoslovniPartner;

@Service
public interface PoslovniPartnerService {

	List<PoslovniPartner> getAll();
}
