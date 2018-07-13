package com.basic.project.web.dto;

public class StavkaFaktureDTO {

	private Long id;
    private Integer kolicina;
    private Double rabat;
    private Double jedinicnaCena;
    private Double stopaPDV;
    private Double osnovica;
    private Double iznosPDV;
    private Double ukupanIznos;
    private ProizvodDTO proizvod;
    
    public StavkaFaktureDTO() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getKolicina() {
		return kolicina;
	}

	public void setKolicina(Integer kolicina) {
		this.kolicina = kolicina;
	}

	public Double getRabat() {
		return rabat;
	}

	public void setRabat(Double rabat) {
		this.rabat = rabat;
	}

	public Double getJedinicnaCena() {
		return jedinicnaCena;
	}

	public void setJedinicnaCena(Double jedinicnaCena) {
		this.jedinicnaCena = jedinicnaCena;
	}

	public Double getStopaPDV() {
		return stopaPDV;
	}

	public void setStopaPDV(Double stopaPDV) {
		this.stopaPDV = stopaPDV;
	}

	public Double getOsnovica() {
		return osnovica;
	}

	public void setOsnovica(Double osnovica) {
		this.osnovica = osnovica;
	}

	public Double getIznosPDV() {
		return iznosPDV;
	}

	public void setIznosPDV(Double iznosPDV) {
		this.iznosPDV = iznosPDV;
	}

	public Double getUkupanIznos() {
		return ukupanIznos;
	}

	public void setUkupanIznos(Double ukupanIznos) {
		this.ukupanIznos = ukupanIznos;
	}

	public ProizvodDTO getProizvod() {
		return proizvod;
	}

	public void setProizvod(ProizvodDTO proizvod) {
		this.proizvod = proizvod;
	}

	@Override
	public String toString() {
		return "StavkaFaktureDTO [id=" + id + ", kolicina=" + kolicina + ", rabat=" + rabat + ", jedinicnaCena="
				+ jedinicnaCena + ", stopaPDV=" + stopaPDV + ", osnovica=" + osnovica + ", iznosPDV=" + iznosPDV
				+ ", ukupanIznos=" + ukupanIznos + ", proizvod=" + proizvod + "]";
	}
     
}
