package com.basic.project.web.dto;

public class PoslovnaGodinaDTO {

	private Long id;
	private Integer godina;
	private boolean zakljucena;
	private PreduzeceDTO preduzece;
	
	public PoslovnaGodinaDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getGodina() {
		return godina;
	}

	public void setGodina(Integer godina) {
		this.godina = godina;
	}

	public boolean isZakljucena() {
		return zakljucena;
	}

	public void setZakljucena(boolean zakljucena) {
		this.zakljucena = zakljucena;
	}

	public PreduzeceDTO getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(PreduzeceDTO preduzece) {
		this.preduzece = preduzece;
	}

	@Override
	public String toString() {
		return "PoslovnaGodinaDTO [id=" + id + ", godina=" + godina + ", zakljucena=" + zakljucena + ", preduzece="
				+ preduzece + "]";
	}

}
