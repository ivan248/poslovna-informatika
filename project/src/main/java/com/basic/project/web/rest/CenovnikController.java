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

import com.basic.project.domain.Cenovnik;
import com.basic.project.service.CenovnikService;

@RestController
@RequestMapping("/api/cenovnik")
public class CenovnikController {
	@Autowired
	private CenovnikService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Cenovnik>> getAll(){
		return new ResponseEntity<List<Cenovnik>>( service.getAll(), HttpStatus.OK);
	}
	
	// GET ONE
		@GetMapping("/getOne")
		public ResponseEntity<Cenovnik> getOneProizvod(@RequestParam("id") Long id) {
			
			return new ResponseEntity<Cenovnik>(service.getOne(id), HttpStatus.OK);
		}
		
		
		@PostMapping("/add")
		public ResponseEntity<Boolean> add(@RequestBody Cenovnik cenovnik) {
			
			System.out.println("pogodio add stavka");
			if(service.add(cenovnik))
				return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
			
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);

		}
		
		// UPDATE ONE
		@PutMapping("/update")
		public ResponseEntity<Boolean> update(@RequestBody Cenovnik cenovnik) {
			
			
			if(service.update(cenovnik))
				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		
		// DELETE ONE
		@DeleteMapping("/delete")
		public ResponseEntity<Boolean> deleteStavkaCenovnika(@RequestParam("id") Long id) {
			
			System.out.println("Pogodio delete");
			
			if(service.delete(id))
				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
}
