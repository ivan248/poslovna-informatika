package com.basic.project.domain;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Narudzbenica")
@Table(name = "narudzbenica")
public class Narudzbenica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "poslovni_partner_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PoslovniPartner poslovniPartner;
    
    @ElementCollection
    @CollectionTable(name="ProizvodKolicina")
    @MapKeyJoinColumn(name="proizvod_id")
    @Column(name="kolicina")
    Map<Proizvod, Integer> listaStavki;
    
    public Narudzbenica() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PoslovniPartner getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(PoslovniPartner poslovniPartner) {
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
		return "Narudzbenica [id=" + id + ", poslovniPartner=" + poslovniPartner + ", listaStavki=" + listaStavki + "]";
	}
    
}
