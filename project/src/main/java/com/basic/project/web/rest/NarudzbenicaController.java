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

import com.basic.project.domain.Narudzbenica;
import com.basic.project.service.NarudzbenicaService;
import com.basic.project.web.dto.Converter;
import com.basic.project.web.dto.NarudzbenicaDTO;
import com.basic.project.web.dto.NarudzbenicaReceiverDTO;

@RestController
@RequestMapping("/api/narudzbenica")
public class NarudzbenicaController {

	@Autowired
	private NarudzbenicaService narudzbenicaService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<NarudzbenicaDTO>> getAll() {
		
		return new ResponseEntity<List<NarudzbenicaDTO>>(Converter.convertNarudzbenicasToNarudzbenicaDTOs(narudzbenicaService.getAll()), HttpStatus.OK);
	}
	
	// GET ONE
	@GetMapping("/getOne")
	public ResponseEntity<Narudzbenica> getOne(@RequestParam("id") Long id) {
		
		return new ResponseEntity<Narudzbenica>(narudzbenicaService.getOne(id), HttpStatus.OK);
	}
	
	/* FORMAT FOR JSON FOR ADDING A NARUDZBENICA
	 *     {
        "poslovniPartner": {
            "id": 1,
            "nazivPreduzeca": "Preduzece 1",
            "emailPreduzeca": "radnja@email.com",
            "pibPreduzeca": 1234,
            "telefonPreduzeca": 5954413,
            "poslovniPartnerVrsta": "FIZICKO_LICE",
            "adresaPreduzeca": {
                "id": 1,
                "ulica": "Kosovska",
                "brojUlice": 75,
                "grad": "Smederevo",
                "postanskiBroj": 11300
            }
        },
        "listaStavki": {
            "1": 3,
            "2": 21
        }
    }
	 */
	
	// ADD ONE
	@PostMapping("/add")
	public ResponseEntity<Boolean> add(@RequestBody NarudzbenicaReceiverDTO narudzbenicaDTO) {
		
		System.out.println("Pogodio add narudzbenica!" + narudzbenicaDTO);
		if(narudzbenicaService.add(Converter.convertNarudzbenicaReceiverDTOToNarudzbenica(narudzbenicaDTO), narudzbenicaDTO.getListaStavki()))
			return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
		
		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);

	}
	
	// UPDATE ONE
	@PutMapping("/update")
	public ResponseEntity<Boolean> updateGrupaProizvoda(@RequestBody NarudzbenicaReceiverDTO narudzbenicaDTO) {
		
		System.out.println("Pogodio add narudzbenica!" + narudzbenicaDTO);
		if(narudzbenicaService.update(Converter.convertNarudzbenicaReceiverDTOToNarudzbenica(narudzbenicaDTO), narudzbenicaDTO.getListaStavki()))
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		
		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
	}
	
	// DELETE ONE
	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> delete(@RequestParam("id") Long id) {
		
		System.out.println("Pogodio delete");
		
		if(narudzbenicaService.delete(id))
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		
		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
	}
}
