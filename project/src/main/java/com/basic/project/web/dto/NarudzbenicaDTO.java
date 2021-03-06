package com.basic.project.web.dto;

import java.util.Map;

import com.basic.project.domain.Proizvod;

public class NarudzbenicaDTO {
	
    private Long id;
	private PoslovniPartnerDTO poslovniPartner;
    Map<Proizvod, Integer> listaStavki;
    
    public NarudzbenicaDTO() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PoslovniPartnerDTO getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(PoslovniPartnerDTO poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}

	public Map<Proizvod, Integer> getListaStavki() {
		return listaStavki;
	}

	public void setListaStavki(Map<Proizvod, Integer> listaStavki) {
		this.listaStavki = listaStavki;
	}

	@Override
	public String toString() {
		return "NarudzbenicaDTO [id=" + id + ", poslovniPartner=" + poslovniPartner + ", listaStavki=" + listaStavki
				+ "]";
	}
	
}
