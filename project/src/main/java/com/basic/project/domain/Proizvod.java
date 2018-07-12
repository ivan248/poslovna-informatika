package com.basic.project.domain;

import java.io.Serializable;
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

@Entity(name = "Proizvod")
@Table(name = "proizvod")
public class Proizvod implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(max = 60)
    @Column
    private String nazivProizvoda;
    
    @Size(max = 50)
    @Column
    private String vrstaProizvoda;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "jedinica_mere_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private JedinicaMere jedinicaMere;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "grupa_proizvoda_id", nullable = true) //da ne pravi problem kada se obrise grupa proizvoda
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private GrupaProizvoda grupaProizvoda;
    
    @OneToMany(mappedBy="proizvod", orphanRemoval=true)
    private List<StavkaCenovnika> stavke;
    
    public Proizvod() {
    	
    }
    
    

	public List<StavkaCenovnika> getStavke() {
		return stavke;
	}



	public void setStavke(List<StavkaCenovnika> stavke) {
		this.stavke = stavke;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivProizvoda() {
		return nazivProizvoda;
	}

	public void setNazivProizvoda(String nazivProizvoda) {
		this.nazivProizvoda = nazivProizvoda;
	}

	public String getVrstaProizvoda() {
		return vrstaProizvoda;
	}

	public void setVrstaProizvoda(String vrstaProizvoda) {
		this.vrstaProizvoda = vrstaProizvoda;
	}

	public JedinicaMere getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(JedinicaMere jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	public GrupaProizvoda getGrupaProizvoda() {
		return grupaProizvoda;
	}

	public void setGrupaProizvoda(GrupaProizvoda grupaProizvoda) {
		this.grupaProizvoda = grupaProizvoda;
	}

	@Override
	public String toString() {
		return "Proizvod [id=" + id + ", nazivProizvoda=" + nazivProizvoda + ", vrstaProizvoda=" + vrstaProizvoda
				+ ", jedinicaMere=" + jedinicaMere + ", grupaProizvoda=" + grupaProizvoda + "]";
	}
    
}
