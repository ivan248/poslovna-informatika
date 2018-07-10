package com.basic.project.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity(name = "JedinicaMere")
@Table(name = "jedinica_mere")
public class JedinicaMere implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(max = 60)
    @Column(unique = true)
    private String nazivJediniceMere;
    
    @Size(max = 3)
    @Column
    private String skracenica;
	
    public JedinicaMere() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivJediniceMere() {
		return nazivJediniceMere;
	}

	public void setNazivJediniceMere(String nazivJediniceMere) {
		this.nazivJediniceMere = nazivJediniceMere;
	}

	public String getSkracenica() {
		return skracenica;
	}

	public void setSkracenica(String skracenica) {
		this.skracenica = skracenica;
	}

	@Override
	public String toString() {
		return "JedinicaMere [id=" + id + ", nazivJediniceMere=" + nazivJediniceMere + ", skracenica=" + skracenica
				+ "]";
	}
   
}
