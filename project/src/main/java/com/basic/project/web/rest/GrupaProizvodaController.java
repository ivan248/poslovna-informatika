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

import com.basic.project.web.dto.Converter;
import com.basic.project.web.dto.GrupaProizvodaDTO;
import com.basic.project.domain.GrupaProizvoda;
import com.basic.project.service.GrupaProizvodaService;

@RestController
@RequestMapping("/api/grupaProizvoda")
public class GrupaProizvodaController {

	@Autowired
	private GrupaProizvodaService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<GrupaProizvodaDTO>> getAll() {
		
		return new ResponseEntity<List<GrupaProizvodaDTO>>(Converter.convertGrupeProizvodaToGrupeProizvodaDTOs(service.getAll()), HttpStatus.OK);
	}
	
	// GET ONE
	@GetMapping("/getOne")
	public ResponseEntity<GrupaProizvodaDTO> getOne(@RequestParam("id") Long id) {
		
		return new ResponseEntity<GrupaProizvodaDTO>(Converter.convertGrupaProizvodaToGrupaProizvodaDTO(service.getOne(id)), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Boolean> add(@RequestBody GrupaProizvodaDTO g) {
		
		GrupaProizvoda gg = Converter.convertGrupaProizvodaDTOtoGrupaProizvoda(g);
		System.out.println("pogodio add stavka");
		if(service.add(gg))
			return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
		
		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);

	}
	
	// UPDATE ONE
	@PutMapping("/update")
	public ResponseEntity<Boolean> updateGrupaProizvoda(@RequestBody GrupaProizvodaDTO g) {
		GrupaProizvoda gg = Converter.convertGrupaProizvodaDTOtoGrupaProizvoda(g);
		
		if(service.update(gg))
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		
		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
	}
	
	// DELETE ONE
	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> delete(@RequestParam("id") Long id) {
		
		System.out.println("Pogodio delete");
		
		if(service.delete(id))
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		
		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
	}
	
}
