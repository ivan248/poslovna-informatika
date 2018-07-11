package com.basic.project.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.basic.project.domain.JedinicaMere;
import com.basic.project.repository.JedinicaMereRepository;

@RestController
@RequestMapping("/api/jedinicaMere")
public class JedinicaMereController {
	
	@Autowired
	private JedinicaMereRepository repository;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<JedinicaMere>> getAllProizvod() {
		
		return new ResponseEntity<List<JedinicaMere>>(repository.findAll(), HttpStatus.OK);
	}
	
	// GET ONE
	@GetMapping("/getOne")
	public ResponseEntity<JedinicaMere> getOneProizvod(@RequestParam("naziv") String naziv) {
		
		return new ResponseEntity<JedinicaMere>(repository.findOneByNazivJediniceMere(naziv), HttpStatus.OK);
	}
}
