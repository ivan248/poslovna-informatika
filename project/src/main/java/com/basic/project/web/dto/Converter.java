package com.basic.project.web.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.basic.project.domain.Adresa;
import com.basic.project.domain.Cenovnik;
import com.basic.project.domain.Faktura;
import com.basic.project.domain.GrupaProizvoda;
import com.basic.project.domain.JedinicaMere;
import com.basic.project.domain.Narudzbenica;
import com.basic.project.domain.PDV;
import com.basic.project.domain.PoslovniPartner;
import com.basic.project.domain.Proizvod;
import com.basic.project.domain.StavkaCenovnika;
import com.basic.project.domain.StopaPDV;

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
	
	public static PoslovniPartner convertPoslovniPartnerDTOToPoslovniPartner(PoslovniPartnerDTO poslovniPartnerDTO) {
		
		PoslovniPartner pp = new PoslovniPartner();
		
		pp.setAdresaPoslovnogPartnera(poslovniPartnerDTO.getAdresaPoslovnogPartnera());
		pp.setEmailPoslovnogPartnera(poslovniPartnerDTO.getEmailPoslovnogPartnera());
		pp.setId(poslovniPartnerDTO.getId());
		pp.setNazivPoslovnogPartnera(poslovniPartnerDTO.getNazivPoslovnogPartnera());
		pp.setPibPoslovnogPartnera(poslovniPartnerDTO.getPibPoslovnogPartnera());
		pp.setPoslovniPartnerVrsta(poslovniPartnerDTO.getPoslovniPartnerVrsta());
		pp.setTelefonPoslovnogPartnera(poslovniPartnerDTO.getTelefonPoslovnogPartnera());
		
		return pp;
	}
	
	public static List<PoslovniPartnerDTO> convertPoslovniPartnersToPoslovniPartnersDTOs(
			List<PoslovniPartner> listaPartnera) {
		
		List<PoslovniPartnerDTO> listaPartneraDTO = new ArrayList<PoslovniPartnerDTO>();
		
		for(PoslovniPartner p:listaPartnera)
		{
			listaPartneraDTO.add(convertPoslovniPartnerToPoslovniPartnerDTO(p));
		}
		
		return listaPartneraDTO;
	}
	
	public static PoslovniPartnerDTO convertPoslovniPartnerToPoslovniPartnerDTO(PoslovniPartner pp) {
	
		PoslovniPartnerDTO poslovniPartnerDTO = new PoslovniPartnerDTO();
		
		poslovniPartnerDTO.setEmailPoslovnogPartnera(pp.getEmailPoslovnogPartnera());
		poslovniPartnerDTO.setId(pp.getId());
		poslovniPartnerDTO.setNazivPoslovnogPartnera(pp.getNazivPoslovnogPartnera());
		poslovniPartnerDTO.setPibPoslovnogPartnera(pp.getPibPoslovnogPartnera());
		poslovniPartnerDTO.setPoslovniPartnerVrsta(pp.getPoslovniPartnerVrsta());
		poslovniPartnerDTO.setTelefonPoslovnogPartnera(pp.getTelefonPoslovnogPartnera());
		
		Adresa a = new Adresa();
		
		a.setBrojUlice(pp.getAdresaPoslovnogPartnera().getBrojUlice());
		a.setGrad(pp.getAdresaPoslovnogPartnera().getGrad());
		a.setId(pp.getAdresaPoslovnogPartnera().getId());
		a.setPostanskiBroj(pp.getAdresaPoslovnogPartnera().getPostanskiBroj());
		a.setUlica(pp.getAdresaPoslovnogPartnera().getUlica());
		
		poslovniPartnerDTO.setAdresaPoslovnogPartnera(a);

		return poslovniPartnerDTO;
	}
	
	//=============================================== Narudzbenica =====================================================
	
	public static Narudzbenica convertNarudzbenicaReceiverDTOToNarudzbenica(NarudzbenicaReceiverDTO narudzbenicaReceiverDTO) {
		
		Narudzbenica n = new Narudzbenica();
		
		n.setId(narudzbenicaReceiverDTO.getId());
		n.setPoslovniPartner(convertPoslovniPartnerDTOToPoslovniPartner(narudzbenicaReceiverDTO.getPoslovniPartner()));
		// map ce biti konvertovana u servisu jer ovde nemam pristup bazi
		return n;
	}
	
	public static List<NarudzbenicaReceiverDTO> convertNarudzbenicasToNarudzbenicaDTOs(List<Narudzbenica> listaNarudzbenica) {
		
		List<NarudzbenicaReceiverDTO> listaNarudzbenicaDTO = new ArrayList<NarudzbenicaReceiverDTO>();
		
		for(Narudzbenica n:listaNarudzbenica)
		{
			listaNarudzbenicaDTO.add(convertNarudzbenicaToNarudzbenicaReceiverDTO(n));
		}
		
		return listaNarudzbenicaDTO;
	}
	
	public static NarudzbenicaReceiverDTO convertNarudzbenicaToNarudzbenicaReceiverDTO(Narudzbenica narudzbenica) {

		NarudzbenicaReceiverDTO nrd = new NarudzbenicaReceiverDTO();
		
		nrd.setId(narudzbenica.getId());
		
		PoslovniPartnerDTO p = new PoslovniPartnerDTO();
		
		Adresa a = new Adresa();
		
		a.setBrojUlice(narudzbenica.getPoslovniPartner().getAdresaPoslovnogPartnera().getBrojUlice());
		a.setGrad(narudzbenica.getPoslovniPartner().getAdresaPoslovnogPartnera().getGrad());
		a.setId(narudzbenica.getPoslovniPartner().getAdresaPoslovnogPartnera().getId());
		a.setPostanskiBroj(narudzbenica.getPoslovniPartner().getAdresaPoslovnogPartnera().getPostanskiBroj());
		a.setUlica(narudzbenica.getPoslovniPartner().getAdresaPoslovnogPartnera().getUlica());
		
		p.setAdresaPoslovnogPartnera(a);
		p.setEmailPoslovnogPartnera(narudzbenica.getPoslovniPartner().getEmailPoslovnogPartnera());
		p.setId(narudzbenica.getPoslovniPartner().getId());
		p.setNazivPoslovnogPartnera(narudzbenica.getPoslovniPartner().getNazivPoslovnogPartnera());
		p.setPibPoslovnogPartnera(narudzbenica.getPoslovniPartner().getPibPoslovnogPartnera());
		p.setPoslovniPartnerVrsta(narudzbenica.getPoslovniPartner().getPoslovniPartnerVrsta());
		p.setTelefonPoslovnogPartnera(narudzbenica.getPoslovniPartner().getTelefonPoslovnogPartnera());
		
		nrd.setPoslovniPartner(p);
		
		List<ListaStavkiHelperObject> listaStavki = new ArrayList<ListaStavkiHelperObject>();
		
		for (Map.Entry<Proizvod, Integer> entry : narudzbenica.getListaStavki().entrySet())
		{
			ListaStavkiHelperObject ls = new ListaStavkiHelperObject();
			
			ls.setId(entry.getKey().getId());
			ls.setKolicina(entry.getValue());
		    listaStavki.add(ls);
		}
		
		nrd.setListaStavki(listaStavki);
		
		return nrd;
	}

	public static NarudzbenicaDTO convertNarudzbenicaToNarudzbenicaDTO(Narudzbenica narudzbenica) {

		NarudzbenicaDTO narudzbenicaDTO = new NarudzbenicaDTO();
		
		narudzbenicaDTO.setId(narudzbenica.getId());
		narudzbenicaDTO.setListaStavki(narudzbenica.getListaStavki());
		
		PoslovniPartnerDTO p = new PoslovniPartnerDTO();
		
		Adresa a = new Adresa();
		
		a.setBrojUlice(narudzbenica.getPoslovniPartner().getAdresaPoslovnogPartnera().getBrojUlice());
		a.setGrad(narudzbenica.getPoslovniPartner().getAdresaPoslovnogPartnera().getGrad());
		a.setId(narudzbenica.getPoslovniPartner().getAdresaPoslovnogPartnera().getId());
		a.setPostanskiBroj(narudzbenica.getPoslovniPartner().getAdresaPoslovnogPartnera().getPostanskiBroj());
		a.setUlica(narudzbenica.getPoslovniPartner().getAdresaPoslovnogPartnera().getUlica());
		
		p.setAdresaPoslovnogPartnera(a);
		p.setEmailPoslovnogPartnera(narudzbenica.getPoslovniPartner().getEmailPoslovnogPartnera());
		p.setId(narudzbenica.getPoslovniPartner().getId());
		p.setNazivPoslovnogPartnera(narudzbenica.getPoslovniPartner().getNazivPoslovnogPartnera());
		p.setPibPoslovnogPartnera(narudzbenica.getPoslovniPartner().getPibPoslovnogPartnera());
		p.setPoslovniPartnerVrsta(narudzbenica.getPoslovniPartner().getPoslovniPartnerVrsta());
		p.setTelefonPoslovnogPartnera(narudzbenica.getPoslovniPartner().getTelefonPoslovnogPartnera());
		
		narudzbenicaDTO.setPoslovniPartner(p);
		
		return narudzbenicaDTO;
	}
	
	//===============================================Stopa pdv=====================================================
	
	public static List<StopaPDVDTO> convertStopePDVToStopePDVDTOs(List<StopaPDV> listStopaPDV) {

		List<StopaPDVDTO> listStopaPDVDTO = new ArrayList<StopaPDVDTO>();
		
		for(StopaPDV s : listStopaPDV)
		{
			listStopaPDVDTO.add(convertStopaPDVToStopaPDVDTO(s));
		}

		return listStopaPDVDTO;
	}
	
	public static StopaPDV convertStopaPDVDTOtoStopaPDV(StopaPDVDTO stopaPDVDTO) {
		
		StopaPDV s = new StopaPDV();
		
		if(stopaPDVDTO.getId() != null)
			s.setId(stopaPDVDTO.getId());
		
		s.setStopa(stopaPDVDTO.getStopa());
		s.setPdv(stopaPDVDTO.getPdv());
		s.setDatumVazenja(stopaPDVDTO.getDatumVazenja());
		
		
		return s;
	}
	
	public static StopaPDVDTO convertStopaPDVToStopaPDVDTO(StopaPDV stopaPDV) {
		
		StopaPDVDTO s = new StopaPDVDTO();
		
		PDV p = new PDV();
		p.setId(stopaPDV.getPdv().getId());
		p.setNaziv(stopaPDV.getPdv().getNaziv());
		p.setStopa(stopaPDV.getPdv().getStopa());

		
		s.setId(stopaPDV.getId());
		s.setStopa(stopaPDV.getStopa());
		s.setPdv(p);
		s.setDatumVazenja(stopaPDV.getDatumVazenja());
		return s;
	}

	public static List<FakturaDTO> convertFakturasToFakturaDTOs(List<Faktura> all) {

		List<FakturaDTO> listaFaktura = new ArrayList<FakturaDTO>();
		
		for(Faktura f:all)
		{
			listaFaktura.add(convertFakturaToFakturaDTO(f));
		}
		
		return listaFaktura;
	}

	public static FakturaDTO convertFakturaToFakturaDTO(Faktura f) {

		FakturaDTO fakturaDTO = new FakturaDTO();
		
		fakturaDTO.setBrojFakture(f.getBrojFakture());
		fakturaDTO.setDatumFakture(f.getDatumFakture());
		fakturaDTO.setDatumValute(f.getDatumValute());
		fakturaDTO.setId(f.getId());
		fakturaDTO.setUkupanIznosBezPDV(f.getUkupanIznosBezPDV());
		fakturaDTO.setUkupanPDV(f.getUkupanPDV());
		fakturaDTO.setUkupanRabat(f.getUkupanRabat());
		fakturaDTO.setUkupnoZaPlacanje(f.getUkupnoZaPlacanje());
		
		return fakturaDTO;
	}


	
}
