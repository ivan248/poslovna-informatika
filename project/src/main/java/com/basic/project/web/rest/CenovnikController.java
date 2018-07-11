package com.basic.project.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.project.domain.Cenovnik;
import com.basic.project.repository.CenovnikRepository;

@RestController
@RequestMapping("/api/cenovnik")
public class CenovnikController {
	@Autowired
	private CenovnikRepository repository;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Cenovnik>> getAll(){
		return new ResponseEntity<List<Cenovnik>>( repository.findAll(), HttpStatus.OK);
	}
}
