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

import com.basic.project.domain.StavkaCenovnika;
import com.basic.project.service.StavkaCenovnikaService;
import com.basic.project.web.dto.Converter;
import com.basic.project.web.dto.StavkaCenovnikaDTO;

@RestController
@RequestMapping("/api/stavkaCenovnika")
public class StavkaCenovnikaController {
	@Autowired
	private StavkaCenovnikaService service;
	
	/*********************************** PROIZVOD CRUD ****************************************************/
	
	// GET ALL
	@GetMapping("/getAll")
	public ResponseEntity<List<StavkaCenovnikaDTO>> getAll() {
		
		return new ResponseEntity<List<StavkaCenovnikaDTO>>(Converter.convertStavkeCenovnikaToStavkeCenovnikaDTOs(service.getAllStavkeCenovnika()), HttpStatus.OK);
	}
	
	// GET ONE
	@GetMapping("/getOne")
	public ResponseEntity<StavkaCenovnikaDTO> getOneProizvod(@RequestParam("id") Long id) {
		
		return new ResponseEntity<StavkaCenovnikaDTO>(Converter.convertStavkaCenovnikaToStavkaCenovnikaDTO(service.getStavkaCenovnika(id)), HttpStatus.OK);
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<Boolean> addStavkaCenovnika(@RequestBody StavkaCenovnikaDTO StavkaCenovnikaDTO) {
		
		StavkaCenovnika s = Converter.convertStavkaCenovnikaDTOtoStavkaCenovnika(StavkaCenovnikaDTO);
		System.out.println("pogodio add stavka");
		if(service.addStavkaCenovnika(s))
			return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
		
		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);

	}
	
	// UPDATE ONE
	@PutMapping("/update")
	public ResponseEntity<Boolean> updateStavkaCenovnika(@RequestBody StavkaCenovnikaDTO stavkaCenovnikaDTO) {
		
		StavkaCenovnika p = Converter.convertStavkaCenovnikaDTOtoStavkaCenovnika(stavkaCenovnikaDTO);
		System.out.println("Pogodio put stavkka");
		
		if(service.updateStavkaCenovnika(p))
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		
		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
	}
	
	// DELETE ONE
	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> deleteStavkaCenovnika(@RequestParam("id") Long id) {
		
		System.out.println("Pogodio delete");
		
		if(service.deleteStavkaCenovnika(id))
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		
		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
	}
	
	/*********************************** PROIZVOD CRUD ****************************************************/

}
