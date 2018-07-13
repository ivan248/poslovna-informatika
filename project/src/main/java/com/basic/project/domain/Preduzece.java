package com.basic.project.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity(name = "Preduzece")
@Table(name = "preduzece")
public class Preduzece implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private String naziv;
	
	@Column 
	private String kontaktTelefon;
	
	@Column
	private Long PIB;
	
	@Column
	private String email;
	
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "adresa_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Adresa adresaPreduzeca;

    public Preduzece() {
    	
    }
    
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

	public Adresa getAdresaPreduzeca() {
		return adresaPreduzeca;
	}

	public void setAdresaPreduzeca(Adresa adresaPreduzeca) {
		this.adresaPreduzeca = adresaPreduzeca;
	}

	@Override
	public String toString() {
		return "Preduzece [id=" + id + ", naziv=" + naziv + ", kontaktTelefon=" + kontaktTelefon
				+ ", PIB=" + PIB + ", email=" + email + ", adresaPreduzeca=" + adresaPreduzeca + "]";
	}
	    
}
