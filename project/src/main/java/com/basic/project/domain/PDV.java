package com.basic.project.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "pdv")
@Table(name = "pdv")
public class PDV implements Serializable{
	
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		
		@Column(unique=true)
		private String naziv;
		
//		@OneToMany(mappedBy="pdv", orphanRemoval=true)
//	    private List<StopaPDV> stopa;
		
		public PDV() {}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNaziv() {
			return naziv;
		}

		public void setNaziv(String naziv) {
			this.naziv = naziv;
		}

//		public List<StopaPDV> getStopa() {
//			return stopa;
//		}
//
//		public void setStopa(List<StopaPDV> stopa) {
//			this.stopa = stopa;
//		}
		

}
