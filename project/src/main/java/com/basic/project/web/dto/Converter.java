package com.basic.project.web.dto;

import java.util.ArrayList;
import java.util.List;

import com.basic.project.domain.Cenovnik;
import com.basic.project.domain.GrupaProizvoda;
import com.basic.project.domain.JedinicaMere;
import com.basic.project.domain.Proizvod;
import com.basic.project.domain.StavkaCenovnika;

public class Converter {

	public static List<ProizvodDTO> convertProizvodsToProizvodDTOs(List<Proizvod> listProizvod) {

		List<ProizvodDTO> listProizvodDTO = new ArrayList<ProizvodDTO>();
		
		for(Proizvod p : listProizvod)
		{
			JedinicaMere jm = new JedinicaMere();
			jm.setId(p.getJedinicaMere().getId());
			jm.setNazivJediniceMere(p.getJedinicaMere().getNazivJediniceMere());
			jm.setSkracenica(p.getJedinicaMere().getSkracenica());
			
			GrupaProizvoda gp = new GrupaProizvoda();
			gp.setId(p.getGrupaProizvoda().getId());
			gp.setNazivGrupeProizvoda(p.getGrupaProizvoda().getNazivGrupeProizvoda());
			
			ProizvodDTO proizvodDTO = new ProizvodDTO(p.getId(), p.getNazivProizvoda(), p.getVrstaProizvoda(),
					jm, gp);
			
			listProizvodDTO.add(proizvodDTO);
		}

		return listProizvodDTO;
	}

	public static Proizvod convertProizvodDTOtoProizvod(ProizvodDTO proizvodDTO) {
		
		Proizvod p = new Proizvod();
		
		if(proizvodDTO.getId() != null)
			p.setId(proizvodDTO.getId());
		
		p.setGrupaProizvoda(proizvodDTO.getGrupaProizvoda());
		p.setJedinicaMere(proizvodDTO.getJedinicaMere());
		p.setNazivProizvoda(proizvodDTO.getNazivProizvoda());
		p.setVrstaProizvoda(proizvodDTO.getVrstaProizvoda());
		
		return p;
	}

	public static ProizvodDTO convertProizvodToProizvodDTO(Proizvod proizvod) {
		
		ProizvodDTO proizvodDTO = new ProizvodDTO();
		
		proizvodDTO.setId(proizvod.getId());
		
		GrupaProizvoda gp = new GrupaProizvoda();
		gp.setId(proizvod.getGrupaProizvoda().getId());
		gp.setNazivGrupeProizvoda(proizvod.getGrupaProizvoda().getNazivGrupeProizvoda());
		
		proizvodDTO.setGrupaProizvoda(gp);
		
		JedinicaMere jm = new JedinicaMere();
		jm.setId(proizvod.getJedinicaMere().getId());
		jm.setNazivJediniceMere(proizvod.getJedinicaMere().getNazivJediniceMere());
		jm.setSkracenica(proizvod.getJedinicaMere().getSkracenica());

		proizvodDTO.setJedinicaMere(jm);
		
		proizvodDTO.setNazivProizvoda(proizvod.getNazivProizvoda());
		proizvodDTO.setVrstaProizvoda(proizvod.getVrstaProizvoda());
		
		return proizvodDTO;
	}
	
	//===============================================STAVKA CENOVNIKA =====================================================
	
	public static List<StavkaCenovnikaDTO> convertStavkeCenovnikaToStavkeCenovnikaDTOs(List<StavkaCenovnika> listStavkaCenovnika) {

		List<StavkaCenovnikaDTO> listStavkaCenovnikaDTO = new ArrayList<StavkaCenovnikaDTO>();
		
		for(StavkaCenovnika s : listStavkaCenovnika)
		{
			Proizvod p = new Proizvod();
			p.setId(s.getProizvod().getId());
			p.setNazivProizvoda(s.getProizvod().getNazivProizvoda());
			p.setJedinicaMere(s.getProizvod().getJedinicaMere());
			p.setVrstaProizvoda(s.getProizvod().getVrstaProizvoda());
			p.setGrupaProizvoda(s.getProizvod().getGrupaProizvoda());


			Cenovnik c = new Cenovnik();
			c.setDatumVazenja(s.getCenovnik().getDatumVazenja());
			c.setId(s.getCenovnik().getId());
			
			StavkaCenovnikaDTO stavka = new StavkaCenovnikaDTO(s.getId(), s.getCena(),p,c);
			
			listStavkaCenovnikaDTO.add(stavka);
		}

		return listStavkaCenovnikaDTO;
	}
	
	public static StavkaCenovnika convertStavkaCenovnikaDTOtoStavkaCenovnika(StavkaCenovnikaDTO stavkaCenovnikaDTO) {
		
		StavkaCenovnika s = new StavkaCenovnika();
		
		if(stavkaCenovnikaDTO.getId() != null)
			s.setId(stavkaCenovnikaDTO.getId());
		
		s.setCena(stavkaCenovnikaDTO.getCena());
		s.setProizvod(stavkaCenovnikaDTO.getProizvod());
		s.setCenovnik(stavkaCenovnikaDTO.getCenovnik());
		
		return s;
	}
	
	public static StavkaCenovnikaDTO convertStavkaCenovnikaToStavkaCenovnikaDTO(StavkaCenovnika stavkaCenovnika) {
		
		StavkaCenovnikaDTO stavkaDTO = new StavkaCenovnikaDTO();
		
		stavkaDTO.setId(stavkaCenovnika.getId());
		
		Proizvod p = new Proizvod();
		p.setId(stavkaCenovnika.getProizvod().getId());
		p.setNazivProizvoda(stavkaCenovnika.getProizvod().getNazivProizvoda());
		p.setVrstaProizvoda(stavkaCenovnika.getProizvod().getVrstaProizvoda());
		p.setGrupaProizvoda(stavkaCenovnika.getProizvod().getGrupaProizvoda());
		p.setJedinicaMere(stavkaCenovnika.getProizvod().getJedinicaMere());
		
		Cenovnik c = new Cenovnik();
		c.setDatumVazenja(stavkaCenovnika.getCenovnik().getDatumVazenja());
		c.setId(stavkaCenovnika.getCenovnik().getId());

		stavkaDTO.setProizvod(p);
		stavkaDTO.setCena(stavkaCenovnika.getCena());
		stavkaDTO.setCenovnik(c);
		
		return stavkaDTO;
	}
}
