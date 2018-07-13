package com.basic.project.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.basic.project.service.FakturaService;

@RestController
@RequestMapping("/api/export")
public class FakturaExport {

	@Autowired
	private FakturaService fakturaService;
	
	// GET ONE
	@GetMapping
	public ResponseEntity<Boolean> getOneFaktura(@RequestParam("id") Long fakturaId) {
		
		
		
		if(fakturaService.export(fakturaId))
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);		
	
		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);		
	}
}
