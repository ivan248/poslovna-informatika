package com.basic.project.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Faktura")
@Table(name = "faktura")
public class Faktura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Size(max = 100)
    @Column
    private String brojFakture;

    @Column
    private Date datumFakture;

    @Column
    private Date datumValute;

    @Column
    private Double ukupanRabat = 0.0;

    @Column
    private Double ukupanIznosBezPDV = 0.0;

    @Column
    private Double ukupanPDV = 0.0;

    @Column
    private Double ukupnoZaPlacanje = 0.0;
    
    @OneToMany(mappedBy="faktura", orphanRemoval=true)
    private List<StavkaFakture> stavkeFakture;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "poslovna_godina_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PoslovnaGodina poslovnaGodina;
    
    public Faktura() {
    	
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

	public List<StavkaFakture> getStavkeFakture() {
		return stavkeFakture;
	}

	public void setStavkeFakture(List<StavkaFakture> stavkeFakture) {
		this.stavkeFakture = stavkeFakture;
	}

	public PoslovnaGodina getPoslovnaGodina() {
		return poslovnaGodina;
	}

	public void setPoslovnaGodina(PoslovnaGodina poslovnaGodina) {
		this.poslovnaGodina = poslovnaGodina;
	}

	@Override
	public String toString() {
		return "Faktura [id=" + id + ", brojFakture=" + brojFakture + ", datumFakture=" + datumFakture
				+ ", datumValute=" + datumValute + ", ukupanRabat=" + ukupanRabat + ", ukupanIznosBezPDV="
				+ ukupanIznosBezPDV + ", ukupanPDV=" + ukupanPDV + ", ukupnoZaPlacanje=" + ukupnoZaPlacanje
				+ ", stavkeFakture=" + stavkeFakture + ", poslovnaGodina=" + poslovnaGodina + "]";
	}
    
}
