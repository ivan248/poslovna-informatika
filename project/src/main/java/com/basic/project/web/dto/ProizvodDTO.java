package com.basic.project.web.dto;

import com.basic.project.domain.GrupaProizvoda;
import com.basic.project.domain.JedinicaMere;


public class ProizvodDTO {

    private Long id;
    private String nazivProizvoda;
    private String vrstaProizvoda;
    private JedinicaMere jedinicaMere;
    private GrupaProizvoda grupaProizvoda;
    
    public ProizvodDTO() {
    	
    }

	public ProizvodDTO(Long id, String nazivProizvoda, String vrstaProizvoda, JedinicaMere jedinicaMere,
			GrupaProizvoda grupaProizvoda) {
		super();
		this.id = id;
		this.nazivProizvoda = nazivProizvoda;
		this.vrstaProizvoda = vrstaProizvoda;
		this.jedinicaMere = jedinicaMere;
		this.grupaProizvoda = grupaProizvoda;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivProizvoda() {
		return nazivProizvoda;
	}

	public void setNazivProizvoda(String nazivProizvoda) {
		this.nazivProizvoda = nazivProizvoda;
	}

	public String getVrstaProizvoda() {
		return vrstaProizvoda;
	}

	public void setVrstaProizvoda(String vrstaProizvoda) {
		this.vrstaProizvoda = vrstaProizvoda;
	}

	public JedinicaMere getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(JedinicaMere jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	public GrupaProizvoda getGrupaProizvoda() {
		return grupaProizvoda;
	}

	public void setGrupaProizvoda(GrupaProizvoda grupaProizvoda) {
		this.grupaProizvoda = grupaProizvoda;
	}

	@Override
	public String toString() {
		return "ProizvodDTO [id=" + id + ", nazivProizvoda=" + nazivProizvoda + ", vrstaProizvoda=" + vrstaProizvoda
				+ ", jedinicaMere=" + jedinicaMere + ", grupaProizvoda=" + grupaProizvoda + "]";
	}
    
}
