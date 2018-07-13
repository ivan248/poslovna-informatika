package com.basic.project.web.dto;

import java.util.List;
import java.util.Map;


public class NarudzbenicaReceiverDTO {

    private Long id;
	private PoslovniPartnerDTO poslovniPartner;
    List<ListaStavkiHelperObject> listaStavki;
    
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

	public List<ListaStavkiHelperObject> getListaStavki() {
		return listaStavki;
	}

	public void setListaStavki(List<ListaStavkiHelperObject> listaStavki) {
		this.listaStavki = listaStavki;
	}

	@Override
	public String toString() {
		return "NarudzbenicaReceiverDTO [id=" + id + ", poslovniPartner=" + poslovniPartner + ", listaStavki="
				+ listaStavki + "]";
	}

}
