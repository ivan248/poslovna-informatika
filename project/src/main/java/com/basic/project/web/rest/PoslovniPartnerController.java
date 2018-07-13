package com.basic.project.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.project.service.PoslovniPartnerService;
import com.basic.project.web.dto.Converter;
import com.basic.project.web.dto.PoslovniPartnerDTO;

@RestController
@RequestMapping("/api/poslovniPartner")
public class PoslovniPartnerController {

	@Autowired
	private PoslovniPartnerService poslovniPartnerService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<PoslovniPartnerDTO>> getAll() {
		
		return new ResponseEntity<List<PoslovniPartnerDTO>>(Converter.convertPoslovniPartnersToPoslovniPartnersDTOs(poslovniPartnerService.getAll()), HttpStatus.OK);
	}
	
}
