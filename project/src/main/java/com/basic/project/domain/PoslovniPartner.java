package com.basic.project.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "PoslovniPartner")
@Table(name = "poslovni_partner")
public class PoslovniPartner implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(max = 60)
    @Column
    private String nazivPoslovnogPartnera;
    
    @Column
    @Size(max = 30)
    private String emailPoslovnogPartnera;
    
    @Column
    private Integer pibPoslovnogPartnera;
    
    @Column
    private Integer telefonPoslovnogPartnera;
    
    @Column
    @Enumerated(EnumType.STRING)
    private PoslovniPartnerVrsta poslovniPartnerVrsta;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "adresa_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Adresa adresaPoslovnogPartnera;
    
    public PoslovniPartner() {
    	
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
		return "PoslovniPartner [id=" + id + ", nazivPoslovnogPartnera=" + nazivPoslovnogPartnera
				+ ", emailPoslovnogPartnera=" + emailPoslovnogPartnera + ", pibPoslovnogPartnera="
				+ pibPoslovnogPartnera + ", telefonPoslovnogPartnera=" + telefonPoslovnogPartnera
				+ ", poslovniPartnerVrsta=" + poslovniPartnerVrsta + ", adresaPoslovnogPartnera="
				+ adresaPoslovnogPartnera + "]";
	}

}
