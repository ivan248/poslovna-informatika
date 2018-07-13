package com.basic.project.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "StavkaFakture")
@Table(name = "stavka_fakture")
public class StavkaFakture implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer kolicina;

    @Column
    private Double rabat;

    @Column
    private Double jedinicnaCena;

    @Column
    private Double stopaPDV;

    @Column
    private Double osnovica;

    @Column
    private Double iznosPDV;

    @Column
    private Double ukupanIznos;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "proizvod_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Proizvod proizvod;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "faktura_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Faktura faktura;
    
    public StavkaFakture() {
    	
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

	public Proizvod getProizvod() {
		return proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

	public Faktura getFaktura() {
		return faktura;
	}

	public void setFaktura(Faktura faktura) {
		this.faktura = faktura;
	}

	@Override
	public String toString() {
		return "StavkaFakture [id=" + id + ", kolicina=" + kolicina + ", rabat=" + rabat + ", jedinicnaCena="
				+ jedinicnaCena + ", stopaPDV=" + stopaPDV + ", osnovica=" + osnovica + ", iznosPDV=" + iznosPDV
				+ ", ukupanIznos=" + ukupanIznos + ", proizvod=" + proizvod + ", faktura=" + faktura + "]";
	}
    
}
