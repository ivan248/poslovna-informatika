package com.basic.project.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity(name = "Cenovnik")
@Table(name = "Cenovnik")
public class Cenovnik implements Serializable,Comparable<Cenovnik> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(unique=true)
    @NotNull
    private Date datumVazenja;
    
    @OneToMany(mappedBy="cenovnik", orphanRemoval=true)
    private List<StavkaCenovnika> stavke;
    
    @Column
    @NotNull
    private boolean aktivan;
    
	public Cenovnik() {
		
	}
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
    public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	public List<StavkaCenovnika> getStavke() {
		return stavke;
	}

	public void setStavke(List<StavkaCenovnika> stavke) {
		this.stavke = stavke;
	}

	public Date getDatumVazenja() {
		return datumVazenja;
	}

	public void setDatumVazenja(Date datumVazenja) {
		this.datumVazenja = datumVazenja;
	}

	@Override
	public String toString() {
		return "Cenovnik [id=" + id + ", datumVazenja=" + datumVazenja + ", stavke=" + stavke + ", aktivan=" + aktivan
				+ "]";
	}

	@Override
	public int compareTo(Cenovnik o) {
		return getDatumVazenja().compareTo(o.getDatumVazenja());
	}

}
