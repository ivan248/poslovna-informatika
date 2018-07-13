package com.basic.project.web.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.basic.project.domain.Faktura;
import com.basic.project.service.FakturaService;
import com.basic.project.web.dto.Converter;
import com.basic.project.web.dto.FakturaDTO;
import com.basic.project.web.dto.NarudzbenicaReceiverDTO;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

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
		
		try {
			
			List<Faktura> listaFaktura = new ArrayList<Faktura>(fakturaService.getKif(java.sql.Date.valueOf(datumOd), java.sql.Date.valueOf(datumDo)));
			
			System.out.println(fakturaService.getAll().size());
			
			JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listaFaktura);

			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("ItemDataSource", itemsJRBean);
			
			JasperPrint jasperPrint = JasperFillManager.fillReport("faktura.jasper", parameters, new JREmptyDataSource());
		    File file = new File("izvestajKIF.pdf");
		    OutputStream outputStream = new FileOutputStream(file);
		    JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
		    
		    outputStream.close();
		    
		    return new ResponseEntity<List<FakturaDTO>>(Converter.convertFakturasToFakturaDTOs(fakturaService.getKif(java.sql.Date.valueOf(datumOd), java.sql.Date.valueOf(datumDo))), HttpStatus.OK);

			
		} catch(Exception e)
		{
			e.printStackTrace();
		    return new ResponseEntity<List<FakturaDTO>>(Converter.convertFakturasToFakturaDTOs(fakturaService.getKif(java.sql.Date.valueOf(datumOd), java.sql.Date.valueOf(datumDo))), HttpStatus.OK);

		}
		
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
