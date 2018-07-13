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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.basic.project.domain.Faktura;
import com.basic.project.service.FakturaService;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
@RequestMapping("/api/export")
public class FakturaExport {

	@Autowired
	private FakturaService fakturaService;
	
	// GET ONE
	@GetMapping
	public ResponseEntity<Boolean> getOneFaktura(@RequestParam("id") Long fakturaId) {
		
		
		
		if(fakturaService.export(fakturaId))
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);		
	
		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);		
	}
	
	// GET ONE
	@GetMapping("/listOfPdf")
	public ResponseEntity<Boolean> getListaFaktura(@RequestParam("id") Long fakturaId) throws Exception {
		
		List<Faktura> listaFaktura = new ArrayList<Faktura>(fakturaService.getAll());
		
		System.out.println(fakturaService.getAll().size());
		
		JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listaFaktura);

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("ItemDataSource", itemsJRBean);
		
		JasperPrint jasperPrint = JasperFillManager.fillReport("faktura.jasper", parameters, new JREmptyDataSource());
	    File file = new File("exportovanaFakturaUPDF.pdf");
	    OutputStream outputStream = new FileOutputStream(file);
	    JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
	    
	    outputStream.close();
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);		
	}
}
