package com.basic.project.web.dto;

import com.basic.project.domain.Adresa;

public class PreduzeceDTO {

    private Long id;
    private String naziv;
    private String kontaktTelefon;
    private Long PIB;
    private String email;
    private Adresa adresaPreduzeca;
    
    public PreduzeceDTO() {
    	
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
		return "PreduzeceDTO [id=" + id + ", naziv=" + naziv + ", kontaktTelefon=" + kontaktTelefon + ", PIB=" + PIB
				+ ", email=" + email + ", adresaPreduzeca=" + adresaPreduzeca + "]";
	}
      
}
