package com.basic.project.web.dto;

import java.sql.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="faktura")
@XmlAccessorType(XmlAccessType.FIELD)
public class FakturaDTO {

	private Long id;
    private String brojFakture;
    private Date datumFakture;
    private Date datumValute;
    private Double ukupanRabat;
    private Double ukupanIznosBezPDV;
    private Double ukupanPDV;
    private Double ukupnoZaPlacanje;
    private List<StavkaFaktureDTO> stavkeFakture;
    private PoslovnaGodinaDTO poslovnaGodina;
    
    public FakturaDTO() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrojFakture() {
		return brojFakture;
	}

	public void setBrojFakture(String brojFakture) {
		this.brojFakture = brojFakture;
	}

	public Date getDatumFakture() {
		return datumFakture;
	}

	public void setDatumFakture(Date datumFakture) {
		this.datumFakture = datumFakture;
	}

	public Date getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(Date datumValute) {
		this.datumValute = datumValute;
	}

	public Double getUkupanRabat() {
		return ukupanRabat;
	}

	public void setUkupanRabat(Double ukupanRabat) {
		this.ukupanRabat = ukupanRabat;
	}

	public Double getUkupanIznosBezPDV() {
		return ukupanIznosBezPDV;
	}

	public void setUkupanIznosBezPDV(Double ukupanIznosBezPDV) {
		this.ukupanIznosBezPDV = ukupanIznosBezPDV;
	}

	public Double getUkupanPDV() {
		return ukupanPDV;
	}

	public void setUkupanPDV(Double ukupanPDV) {
		this.ukupanPDV = ukupanPDV;
	}

	public Double getUkupnoZaPlacanje() {
		return ukupnoZaPlacanje;
	}

	public void setUkupnoZaPlacanje(Double ukupnoZaPlacanje) {
		this.ukupnoZaPlacanje = ukupnoZaPlacanje;
	}

	public List<StavkaFaktureDTO> getStavkeFakture() {
		return stavkeFakture;
	}

	public void setStavkeFakture(List<StavkaFaktureDTO> stavkeFakture) {
		this.stavkeFakture = stavkeFakture;
	}

	public PoslovnaGodinaDTO getPoslovnaGodina() {
		return poslovnaGodina;
	}

	public void setPoslovnaGodina(PoslovnaGodinaDTO poslovnaGodina) {
		this.poslovnaGodina = poslovnaGodina;
	}

	@Override
	public String toString() {
		return "FakturaDTO [id=" + id + ", brojFakture=" + brojFakture + ", datumFakture=" + datumFakture
				+ ", datumValute=" + datumValute + ", ukupanRabat=" + ukupanRabat + ", ukupanIznosBezPDV="
				+ ukupanIznosBezPDV + ", ukupanPDV=" + ukupanPDV + ", ukupnoZaPlacanje=" + ukupnoZaPlacanje
				+ ", stavkeFakture=" + stavkeFakture + ", poslovnaGodina=" + poslovnaGodina + "]";
	}
    
}
