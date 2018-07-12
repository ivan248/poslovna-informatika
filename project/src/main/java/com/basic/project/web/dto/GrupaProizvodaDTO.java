package com.basic.project.web.dto;

import com.basic.project.domain.PDV;

public class GrupaProizvodaDTO {
	private Long id;
	private String nazivGrupeProizvoda;
	private PDV pdv;
	
	public GrupaProizvodaDTO() {}
	
	public GrupaProizvodaDTO(Long id, String n, PDV p) {
		this.id = id;
		this.nazivGrupeProizvoda =  n;
		this.pdv = p;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivGrupeProizvoda() {
		return nazivGrupeProizvoda;
	}

	public void setNazivGrupeProizvoda(String nazivGrupeProizvoda) {
		this.nazivGrupeProizvoda = nazivGrupeProizvoda;
	}

	public PDV getPdv() {
		return pdv;
	}

	public void setPdv(PDV pdv) {
		this.pdv = pdv;
	}
	
	
}
