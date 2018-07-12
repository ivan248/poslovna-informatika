package com.basic.project.web.dto;

import java.util.Map;


public class NarudzbenicaReceiverDTO {

    private Long id;
	private PoslovniPartnerDTO poslovniPartner;
    Map<Long, Integer> listaStavki;
    
    public NarudzbenicaReceiverDTO() {
    	
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

	public Map<Long, Integer> getListaStavki() {
		return listaStavki;
	}

	public void setListaStavki(Map<Long, Integer> listaStavki) {
		this.listaStavki = listaStavki;
	}

	@Override
	public String toString() {
		return "NarudzbenicaReceiverDTO [id=" + id + ", poslovniPartner=" + poslovniPartner + ", listaStavki="
				+ listaStavki + "]";
	}
    
}
