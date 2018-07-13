package com.basic.project.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.basic.project.service.FakturaService;
import com.basic.project.web.dto.Converter;
import com.basic.project.web.dto.FakturaDTO;

@RestController
@RequestMapping("/api/proizvod")
public class FakturaController {

	@Autowired
	private FakturaService fakturaService;
	
	// GET ALL
	@GetMapping("/getAll")
	public ResponseEntity<List<FakturaDTO>> getAllProizvod() {
		
		return new ResponseEntity<List<FakturaDTO>>(Converter.convertFakturasToFakturaDTOs(fakturaService.getAll()), HttpStatus.OK);
	}
	
	// GET ONE
	@GetMapping("/getOne")
	public ResponseEntity<FakturaDTO> getOneProizvod(@RequestParam("id") Long proizvodId) {
		
		return new ResponseEntity<FakturaDTO>(Converter.convertFakturaToFakturaDTO(fakturaService.getFaktura(proizvodId)), HttpStatus.OK);
	}
	
}
