package com.basic.project.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.basic.project.domain.GrupaProizvoda;
import com.basic.project.repository.GrupaProizvodaRepository;

@RestController
@RequestMapping("/api/grupaProizvoda")
public class GrupaProizvodaController {

	@Autowired
	private GrupaProizvodaRepository repository;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<GrupaProizvoda>> getAllProizvod() {
		
		return new ResponseEntity<List<GrupaProizvoda>>(repository.findAll(), HttpStatus.OK);
	}
	
	// GET ONE
	@GetMapping("/getOne")
	public ResponseEntity<GrupaProizvoda> getOneProizvod(@RequestParam("naziv") String naziv) {
		
		return new ResponseEntity<GrupaProizvoda>(repository.findOneByNazivGrupeProizvoda(naziv), HttpStatus.OK);
	}
}
