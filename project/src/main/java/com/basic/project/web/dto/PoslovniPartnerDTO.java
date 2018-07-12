package com.basic.project.web.dto;

import com.basic.project.domain.Adresa;
import com.basic.project.domain.PoslovniPartnerVrsta;

public class PoslovniPartnerDTO {

    private Long id;
    private String nazivPreduzeca;
    private String emailPreduzeca;
    private Integer pibPreduzeca;
    private Integer telefonPreduzeca;
    private PoslovniPartnerVrsta poslovniPartnerVrsta;
    private Adresa adresaPreduzeca;
    
    public PoslovniPartnerDTO() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivPreduzeca() {
		return nazivPreduzeca;
	}

	public void setNazivPreduzeca(String nazivPreduzeca) {
		this.nazivPreduzeca = nazivPreduzeca;
	}

	public String getEmailPreduzeca() {
		return emailPreduzeca;
	}

	public void setEmailPreduzeca(String emailPreduzeca) {
		this.emailPreduzeca = emailPreduzeca;
	}

	public Integer getPibPreduzeca() {
		return pibPreduzeca;
	}

	public void setPibPreduzeca(Integer pibPreduzeca) {
		this.pibPreduzeca = pibPreduzeca;
	}

	public Integer getTelefonPreduzeca() {
		return telefonPreduzeca;
	}

	public void setTelefonPreduzeca(Integer telefonPreduzeca) {
		this.telefonPreduzeca = telefonPreduzeca;
	}

	public PoslovniPartnerVrsta getPoslovniPartnerVrsta() {
		return poslovniPartnerVrsta;
	}

	public void setPoslovniPartnerVrsta(PoslovniPartnerVrsta poslovniPartnerVrsta) {
		this.poslovniPartnerVrsta = poslovniPartnerVrsta;
	}

	public Adresa getAdresaPreduzeca() {
		return adresaPreduzeca;
	}

	public void setAdresaPreduzeca(Adresa adresaPreduzeca) {
		this.adresaPreduzeca = adresaPreduzeca;
	}

	@Override
	public String toString() {
		return "PoslovniPartnerDTO [id=" + id + ", nazivPreduzeca=" + nazivPreduzeca + ", emailPreduzeca="
				+ emailPreduzeca + ", pibPreduzeca=" + pibPreduzeca + ", telefonPreduzeca=" + telefonPreduzeca
				+ ", poslovniPartnerVrsta=" + poslovniPartnerVrsta + ", adresaPreduzeca=" + adresaPreduzeca + "]";
	}
    
}
