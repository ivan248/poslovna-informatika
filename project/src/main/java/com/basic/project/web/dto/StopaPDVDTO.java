package com.basic.project.web.dto;

import java.util.Date;

import com.basic.project.domain.PDV;

public class StopaPDVDTO {
	
	private Long id;
	private Double stopa;
	private Date datumVazenja;
	private PDV pdv;
	
	public StopaPDVDTO() {}
	public StopaPDVDTO(Long id, Double stopa, Date datum, PDV pdv) {
		this.id = id;
		this.stopa = stopa;
		this.datumVazenja = datum;
		this.pdv = pdv;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getStopa() {
		return stopa;
	}
	public void setStopa(Double double1) {
		this.stopa = double1;
	}
	public Date getDatumVazenja() {
		return datumVazenja;
	}
	public void setDatumVazenja(Date datumVazenja) {
		this.datumVazenja = datumVazenja;
	}
	public PDV getPdv() {
		return pdv;
	}
	public void setPdv(PDV pdv) {
		this.pdv = pdv;
	}
	
	
}
