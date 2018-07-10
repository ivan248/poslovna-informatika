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

import com.basic.project.domain.Proizvod;
import com.basic.project.service.ProizvodService;
import com.basic.project.web.dto.Converter;
import com.basic.project.web.dto.ProizvodDTO;

@RestController
@RequestMapping("/api/proizvod")
public class ProizvodController {

	@Autowired
	private ProizvodService proizvodService;
	
	/*********************************** PROIZVOD CRUD ****************************************************/
	
	// GET ALL
	@GetMapping("/getAll")
	public ResponseEntity<List<ProizvodDTO>> getAllProizvod() {
		
		return new ResponseEntity<List<ProizvodDTO>>(Converter.convertProizvodsToProizvodDTOs(proizvodService.getAllProizvod()), HttpStatus.OK);
	}
	
	// GET ONE
	@GetMapping("/getOne")
	public ResponseEntity<ProizvodDTO> getOneProizvod(@RequestParam("id") Long proizvodId) {
		
		return new ResponseEntity<ProizvodDTO>(Converter.convertProizvodToProizvodDTO(proizvodService.getProizvod(proizvodId)), HttpStatus.OK);
	}
	
	/*
	 * 
	 * json format for adding a new item
	 * {
        "nazivProizvoda": "Ruski Malamut",
        "vrstaProizvoda": "Zivotinja velika",
        "jedinicaMere": {
            "nazivJediniceMere": "Brojno stanje",
            "skracenica": "br"
        },
        "grupaProizvoda": {
            "nazivGrupeProizvoda": "Psi"
        }
  }
	 */
	// ADD ONE
	@PostMapping("/add")
	@RequestMapping(consumes="application/json", produces="application/json")
	public ResponseEntity<Boolean> addProizvod(@RequestBody ProizvodDTO proizvodDTO) {
		
		Proizvod p = Converter.convertProizvodDTOtoProizvod(proizvodDTO);
		
		if(proizvodService.addProizvod(p))
			return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
		
		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);

	}
	
	// UPDATE ONE
	@PutMapping("/update")
	public ResponseEntity<Boolean> updateProizvod(@RequestBody ProizvodDTO proizvodDTO) {
		
		Proizvod p = Converter.convertProizvodDTOtoProizvod(proizvodDTO);
		System.out.println("Pogodio put");
		
		if(proizvodService.updateProizvod(p))
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		
		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
	}
	
	// DELETE ONE
	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> deleteProizvod(@RequestParam("id") Long proizvodId) {
		
		System.out.println("Pogodio delete");
		
		if(proizvodService.deleteProizvod(proizvodId))
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		
		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
	}
	
	/*********************************** PROIZVOD CRUD ****************************************************/

}
