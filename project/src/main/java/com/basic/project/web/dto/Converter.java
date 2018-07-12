package com.basic.project.web.dto;

import java.util.ArrayList;
import java.util.List;

import com.basic.project.domain.Cenovnik;
import com.basic.project.domain.GrupaProizvoda;
import com.basic.project.domain.JedinicaMere;
import com.basic.project.domain.PDV;
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
			p.setVrstaProizvoda(s.getProizvod().getVrstaProizvoda());
			
				JedinicaMere m = new JedinicaMere();
				m.setId(s.getProizvod().getJedinicaMere().getId());
				m.setNazivJediniceMere(s.getProizvod().getJedinicaMere().getNazivJediniceMere());
				m.setSkracenica(s.getProizvod().getJedinicaMere().getSkracenica());
			p.setJedinicaMere(m);
			
				GrupaProizvoda g = new GrupaProizvoda();
				g.setId(s.getProizvod().getGrupaProizvoda().getId());
				g.setNazivGrupeProizvoda(s.getProizvod().getGrupaProizvoda().getNazivGrupeProizvoda());
			p.setGrupaProizvoda(g);
				


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
		
		
		
		Proizvod p = new Proizvod();
		p.setId(stavkaCenovnika.getProizvod().getId());
		p.setNazivProizvoda(stavkaCenovnika.getProizvod().getNazivProizvoda());
		p.setVrstaProizvoda(stavkaCenovnika.getProizvod().getVrstaProizvoda());
		p.setGrupaProizvoda(stavkaCenovnika.getProizvod().getGrupaProizvoda());
			p.getGrupaProizvoda().setId(stavkaCenovnika.getProizvod().getGrupaProizvoda().getId());
			p.getGrupaProizvoda().setNazivGrupeProizvoda(stavkaCenovnika.getProizvod().getGrupaProizvoda().getNazivGrupeProizvoda());
		p.setJedinicaMere(stavkaCenovnika.getProizvod().getJedinicaMere());
			p.getJedinicaMere().setId(stavkaCenovnika.getProizvod().getJedinicaMere().getId());
			p.getJedinicaMere().setNazivJediniceMere(stavkaCenovnika.getProizvod().getJedinicaMere().getNazivJediniceMere());
			p.getJedinicaMere().setSkracenica(stavkaCenovnika.getProizvod().getJedinicaMere().getSkracenica());
		
		Cenovnik c = new Cenovnik();
		c.setDatumVazenja(stavkaCenovnika.getCenovnik().getDatumVazenja());
		c.setId(stavkaCenovnika.getCenovnik().getId());

		
		stavkaDTO.setId(stavkaCenovnika.getId());
		stavkaDTO.setCena(stavkaCenovnika.getCena());
		stavkaDTO.setCenovnik(c);
		stavkaDTO.setProizvod(p);
		
		return stavkaDTO;
	}
	
	//===============================================Grupa proizvoda =====================================================
	public static List<GrupaProizvodaDTO> convertGrupeProizvodaToGrupeProizvodaDTOs(List<GrupaProizvoda> listGrupaProizvoda) {

		List<GrupaProizvodaDTO> listGrupaProizvodaDTO = new ArrayList<GrupaProizvodaDTO>();
		
		for(GrupaProizvoda s : listGrupaProizvoda)
		{
			convertGrupaProizvodaToGrupaProizvodaDTO(s);
			listGrupaProizvodaDTO.add(convertGrupaProizvodaToGrupaProizvodaDTO(s));
		}

		return listGrupaProizvodaDTO;
	}
	
	public static GrupaProizvoda convertGrupaProizvodaDTOtoGrupaProizvoda(GrupaProizvodaDTO grupaProizvodaDTO) {
		
		GrupaProizvoda g = new GrupaProizvoda();
		
		if(grupaProizvodaDTO.getId() != null)
			g.setId(grupaProizvodaDTO.getId());
		
		g.setNazivGrupeProizvoda(grupaProizvodaDTO.getNazivGrupeProizvoda());
		g.setPdv(grupaProizvodaDTO.getPdv());
		
		
		return g;
	}
	
	public static GrupaProizvodaDTO convertGrupaProizvodaToGrupaProizvodaDTO(GrupaProizvoda grupaProizvoda) {
		
		GrupaProizvodaDTO g = new GrupaProizvodaDTO();
		
		PDV p = new PDV();
		p.setId(grupaProizvoda.getPdv().getId());
		p.setNaziv(grupaProizvoda.getPdv().getNaziv());
		//p.setStopa(grupaProizvoda.getPdv().getStopa());

		
		g.setId(grupaProizvoda.getId());
		g.setNazivGrupeProizvoda(grupaProizvoda.getNazivGrupeProizvoda());
		g.setPdv(p);
		return g;
	}
	
}
