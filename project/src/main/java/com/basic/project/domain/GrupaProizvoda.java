package com.basic.project.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

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
