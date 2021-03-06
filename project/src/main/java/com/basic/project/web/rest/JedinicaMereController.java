package com.basic.project.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.basic.project.domain.JedinicaMere;
import com.basic.project.service.JedinicaMereService;

@RestController
@RequestMapping("/api/jedinicaMere")
public class JedinicaMereController {
	
	@Autowired
	private JedinicaMereService jedinicaMereService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<JedinicaMere>> getAll() {
		
		return new ResponseEntity<List<JedinicaMere>>(jedinicaMereService.getAll(), HttpStatus.OK);
	}
	
	// GET ONE
	@GetMapping("/getOne")
	public ResponseEntity<JedinicaMere> getOne(@RequestParam("id") Long id) {
		
		return new ResponseEntity<JedinicaMere>(jedinicaMereService.getOne(id), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Boolean> add(@RequestBody JedinicaMere jm) {
		
		System.out.println("Pogodio add jedinicaMere!");
		if(jedinicaMereService.add(jm))
			return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
		
		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);

	}
	
	// UPDATE ONE
	@PutMapping("/update")
	public ResponseEntity<Boolean> updateGrupaProizvoda(@RequestBody JedinicaMere jm) {
		
		if(jedinicaMereService.update(jm))
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		
		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
	}
	
	// DELETE ONE
	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> delete(@RequestParam("id") Long id) {
		
		System.out.println("Pogodio delete");
		
		if(jedinicaMereService.delete(id))
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		
		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
	}
}
