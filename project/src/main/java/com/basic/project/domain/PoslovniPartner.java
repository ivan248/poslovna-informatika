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
    private String nazivPreduzeca;
    
    @Column
    @Size(max = 30)
    private String emailPreduzeca;
    
    @Column
    private Integer pibPreduzeca;
    
    @Column
    private Integer telefonPreduzeca;
    
    @Column
    private PoslovniPartnerVrsta poslovniPartnerVrsta;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "adresa_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Adresa adresaPreduzeca;
    
    public PoslovniPartner() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivPreduzeca() {
		return nazivPreduzeca;
	}

	public void setNazivPreduzeca(String nazivPreduzeca) {
		this.nazivPreduzeca = nazivPreduzeca;
	}

	public String getEmailPreduzeca() {
		return emailPreduzeca;
	}

	public void setEmailPreduzeca(String emailPreduzeca) {
		this.emailPreduzeca = emailPreduzeca;
	}

	public Integer getPibPreduzeca() {
		return pibPreduzeca;
	}

	public void setPibPreduzeca(Integer pibPreduzeca) {
		this.pibPreduzeca = pibPreduzeca;
	}

	public Integer getTelefonPreduzeca() {
		return telefonPreduzeca;
	}

	public void setTelefonPreduzeca(Integer telefonPreduzeca) {
		this.telefonPreduzeca = telefonPreduzeca;
	}

	public PoslovniPartnerVrsta getPoslovniPartnerVrsta() {
		return poslovniPartnerVrsta;
	}

	public void setPoslovniPartnerVrsta(PoslovniPartnerVrsta poslovniPartnerVrsta) {
		this.poslovniPartnerVrsta = poslovniPartnerVrsta;
	}

	public Adresa getAdresaPreduzeca() {
		return adresaPreduzeca;
	}

	public void setAdresaPreduzeca(Adresa adresaPreduzeca) {
		this.adresaPreduzeca = adresaPreduzeca;
	}

	@Override
	public String toString() {
		return "PoslovniPartner [id=" + id + ", nazivPreduzeca=" + nazivPreduzeca + ", emailPreduzeca=" + emailPreduzeca
				+ ", pibPreduzeca=" + pibPreduzeca + ", telefonPreduzeca=" + telefonPreduzeca
				+ ", poslovniPartnerVrsta=" + poslovniPartnerVrsta + ", adresaPreduzeca=" + adresaPreduzeca + "]";
	}
    
}
