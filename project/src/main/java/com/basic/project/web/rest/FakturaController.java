package com.basic.project.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.basic.project.service.FakturaService;
import com.basic.project.web.dto.Converter;
import com.basic.project.web.dto.FakturaDTO;
import com.basic.project.web.dto.NarudzbenicaReceiverDTO;

@RestController
@RequestMapping("/api/faktura")
public class FakturaController {

	@Autowired
	private FakturaService fakturaService;
	
	// GET ALL
	@GetMapping("/getAll")
	public ResponseEntity<List<FakturaDTO>> getAllFaktura() {
		
		return new ResponseEntity<List<FakturaDTO>>(Converter.convertFakturasToFakturaDTOs(fakturaService.getAll()), HttpStatus.OK);
	}
	
	// GET ALL BY INTERVAL BETWEEN 2 DATES
	@GetMapping("/getKif")
	public ResponseEntity<List<FakturaDTO>> getKif(@RequestParam("datumOd") String datumOd, 
			@RequestParam("datumDo") String datumDo) {
		
		return new ResponseEntity<List<FakturaDTO>>(Converter.convertFakturasToFakturaDTOs(fakturaService.getKif(java.sql.Date.valueOf(datumOd), java.sql.Date.valueOf(datumDo))), HttpStatus.OK);
	}
	
	// GET ONE
	@GetMapping("/getOne")
	public ResponseEntity<FakturaDTO> getOneFaktura(@RequestParam("id") Long proizvodId) {
		
		if(fakturaService.getFaktura(proizvodId) != null)
			return new ResponseEntity<FakturaDTO>(Converter.convertFakturaToFakturaDTO(fakturaService.getFaktura(proizvodId)), HttpStatus.OK);
	
		return new ResponseEntity<FakturaDTO>(new FakturaDTO(), HttpStatus.BAD_REQUEST);		
	}
	
	// ADD ONE
	@PostMapping("/add")
	public ResponseEntity<Boolean> add(@RequestBody NarudzbenicaReceiverDTO narudzbenicaDTO) {
		
		System.out.println("Pogodio add faktura sa narudzbenicom: " + narudzbenicaDTO);
		if(fakturaService.add(Converter.convertNarudzbenicaReceiverDTOToNarudzbenica(narudzbenicaDTO), narudzbenicaDTO.getListaStavki()))
			return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
		
		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);

	}
	
	// DELETE ONE
	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> delete(@RequestParam("id") Long id) {
		
		System.out.println("Pogodio delete fakture");
		
		if(fakturaService.delete(id))
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		
		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
	}
	
}
