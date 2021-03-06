package com.basic.project.web.dto;

import com.basic.project.domain.Cenovnik;
import com.basic.project.domain.Proizvod;

public class StavkaCenovnikaDTO {
	private Long id;
	private double cena;
	private Proizvod proizvod;
	private Cenovnik cenovnik;
	
	public StavkaCenovnikaDTO(Long id,double cena,Proizvod proizvod, Cenovnik cenovnik) {
    	this.id = id;
    	this.cena = cena;
    	this.proizvod = proizvod;
    	this.cenovnik = cenovnik;
    }
	
	public StavkaCenovnikaDTO() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Proizvod getProizvod() {
		return proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

	public Cenovnik getCenovnik() {
		return cenovnik;
	}

	public void setCenovnik(Cenovnik cenovnik) {
		this.cenovnik = cenovnik;
	}
}
