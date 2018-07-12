package com.basic.project.web.dto;

import java.util.Date;

import com.basic.project.domain.PDV;

public class StopaPDVDTO {
	
	private Long id;
	private float stopa;
	private Date datumVazenja;
	private PDV pdv;
	
	public StopaPDVDTO() {}
	public StopaPDVDTO(Long id, float stopa, Date datum, PDV pdv) {
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
	public float getStopa() {
		return stopa;
	}
	public void setStopa(float stopa) {
		this.stopa = stopa;
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
