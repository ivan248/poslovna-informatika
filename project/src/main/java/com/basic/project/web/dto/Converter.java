package com.basic.project.web.dto;

import java.util.ArrayList;
import java.util.List;

import com.basic.project.domain.GrupaProizvoda;
import com.basic.project.domain.JedinicaMere;
import com.basic.project.domain.Proizvod;

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
		
		p.setGrupaProizvoda(proizvodDTO.getGrupaProizvoda());
		p.setJedinicaMere(proizvodDTO.getJedinicaMere());
		p.setNazivProizvoda(proizvodDTO.getNazivProizvoda());
		p.setVrstaProizvoda(proizvodDTO.getVrstaProizvoda());
		
		return p;
	}
}
