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

@Entity(name = "GrupaProizvoda")
@Table(name = "grupa_proizvoda")
public class GrupaProizvoda implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(max = 60)
    @Column(unique = true)
    private String nazivGrupeProizvoda;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pdv_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PDV pdv;
    
    public PDV getPdv() {
		return pdv;
	}

	public void setPdv(PDV pdv) {
		this.pdv = pdv;
	}

	public GrupaProizvoda() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivGrupeProizvoda() {
		return nazivGrupeProizvoda;
	}

	public void setNazivGrupeProizvoda(String nazivGrupeProizvoda) {
		this.nazivGrupeProizvoda = nazivGrupeProizvoda;
	}

	@Override
	public String toString() {
		return "GrupaProizvoda [id=" + id + ", nazivGrupeProizvoda=" + nazivGrupeProizvoda + "]";
	}
    
}
