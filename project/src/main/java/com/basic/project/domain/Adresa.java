package com.basic.project.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity(name = "Adresa")
@Table(name = "adresa")
public class Adresa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(max = 60)
    @Column
    private String ulica;

    @Column
    private Integer brojUlice;
    
    @Size(max = 60)
    @Column
    private String grad;

    @Column
    private Integer postanskiBroj;
    
    public Adresa() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public Integer getBrojUlice() {
		return brojUlice;
	}

	public void setBrojUlice(Integer brojUlice) {
		this.brojUlice = brojUlice;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public Integer getPostanskiBroj() {
		return postanskiBroj;
	}

	public void setPostanskiBroj(Integer postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}

	@Override
	public String toString() {
		return "Adresa [id=" + id + ", ulica=" + ulica + ", brojUlice=" + brojUlice + ", grad=" + grad
				+ ", postanskiBroj=" + postanskiBroj + "]";
	}
    
}
