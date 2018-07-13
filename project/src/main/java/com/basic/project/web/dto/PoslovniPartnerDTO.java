package com.basic.project.web.dto;

import com.basic.project.domain.Adresa;
import com.basic.project.domain.PoslovniPartnerVrsta;

public class PoslovniPartnerDTO {

    private Long id;
    private String nazivPoslovnogPartnera;
    private String emailPoslovnogPartnera;
    private Integer pibPoslovnogPartnera;
    private Integer telefonPoslovnogPartnera;
    private PoslovniPartnerVrsta poslovniPartnerVrsta;
    private Adresa adresaPoslovnogPartnera;
    
    public PoslovniPartnerDTO() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivPoslovnogPartnera() {
		return nazivPoslovnogPartnera;
	}

	public void setNazivPoslovnogPartnera(String nazivPoslovnogPartnera) {
		this.nazivPoslovnogPartnera = nazivPoslovnogPartnera;
	}

	public String getEmailPoslovnogPartnera() {
		return emailPoslovnogPartnera;
	}

	public void setEmailPoslovnogPartnera(String emailPoslovnogPartnera) {
		this.emailPoslovnogPartnera = emailPoslovnogPartnera;
	}

	public Integer getPibPoslovnogPartnera() {
		return pibPoslovnogPartnera;
	}

	public void setPibPoslovnogPartnera(Integer pibPoslovnogPartnera) {
		this.pibPoslovnogPartnera = pibPoslovnogPartnera;
	}

	public Integer getTelefonPoslovnogPartnera() {
		return telefonPoslovnogPartnera;
	}

	public void setTelefonPoslovnogPartnera(Integer telefonPoslovnogPartnera) {
		this.telefonPoslovnogPartnera = telefonPoslovnogPartnera;
	}

	public PoslovniPartnerVrsta getPoslovniPartnerVrsta() {
		return poslovniPartnerVrsta;
	}

	public void setPoslovniPartnerVrsta(PoslovniPartnerVrsta poslovniPartnerVrsta) {
		this.poslovniPartnerVrsta = poslovniPartnerVrsta;
	}

	public Adresa getAdresaPoslovnogPartnera() {
		return adresaPoslovnogPartnera;
	}

	public void setAdresaPoslovnogPartnera(Adresa adresaPoslovnogPartnera) {
		this.adresaPoslovnogPartnera = adresaPoslovnogPartnera;
	}

	@Override
	public String toString() {
		return "PoslovniPartnerDTO [id=" + id + ", nazivPoslovnogPartnera=" + nazivPoslovnogPartnera + ", emailPoslovnogPartnera="
				+ emailPoslovnogPartnera + ", pibPoslovnogPartnera=" + pibPoslovnogPartnera + ", telefonPoslovnogPartnera=" + telefonPoslovnogPartnera
				+ ", poslovniPartnerVrsta=" + poslovniPartnerVrsta + ", adresaPoslovnogPartnera=" + adresaPoslovnogPartnera + "]";
	}
    
}
