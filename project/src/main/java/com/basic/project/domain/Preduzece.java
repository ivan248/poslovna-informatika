package com.basic.project.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity(name = "Preduzece")
@Table(name = "preduzece")
public class Preduzece implements Serializable {
	 
	
	private static final long serialVersionUID = 1L;
	private static final Preduzece instance = new Preduzece();
	public static Preduzece getInstance() {
		return instance;
	}

	private Preduzece() {}
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private String naziv;
	
	@Column
	private String adresa;
	
	@Column 
	private String kontaktTelefon;
	
	@Column
	private Long PIB;
	
	@Column
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getKontaktTelefon() {
		return kontaktTelefon;
	}

	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}

	public Long getPIB() {
		return PIB;
	}

	public void setPIB(Long pIB) {
		PIB = pIB;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	    
}
