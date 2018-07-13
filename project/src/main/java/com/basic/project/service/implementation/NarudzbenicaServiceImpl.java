package com.basic.project.service.implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.project.domain.Narudzbenica;
import com.basic.project.domain.Proizvod;
import com.basic.project.repository.NarudzbenicaRepository;
import com.basic.project.repository.ProizvodRepository;
import com.basic.project.service.NarudzbenicaService;
import com.basic.project.web.dto.ListaStavkiHelperObject;

@Service
public class NarudzbenicaServiceImpl implements NarudzbenicaService {

	@Autowired
	private NarudzbenicaRepository narudzbenicaRepository;
	
	@Autowired
	private ProizvodRepository proizvodRepository;

	@Override
	public List<Narudzbenica> getAll() {

		System.out.println(narudzbenicaRepository.findAll());
		return narudzbenicaRepository.findAll();
	}

	@Override
	public Narudzbenica getOne(Long id) {

		try {

			return narudzbenicaRepository.findById(id).get();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean add(Narudzbenica n, List<ListaStavkiHelperObject> listaStavkiHelper) {

		try {
			
			Map<Proizvod, Integer> listaStavki = new HashMap<Proizvod, Integer>();
			
			for (ListaStavkiHelperObject ls : listaStavkiHelper)
			{
			    listaStavki.put(proizvodRepository.getOne(ls.getId()), ls.getKolicina());
			}
			
			n.setListaStavki(listaStavki);
			
			narudzbenicaRepository.save(n);
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Narudzbenica n, List<ListaStavkiHelperObject> listaStavkiHelper) {

		try {
			
			Map<Proizvod, Integer> listaStavki = new HashMap<Proizvod, Integer>();
			
			for (ListaStavkiHelperObject ls : listaStavkiHelper)
			{
			    listaStavki.put(proizvodRepository.getOne(ls.getId()), ls.getKolicina());
			}
			
			n.setListaStavki(listaStavki);

			narudzbenicaRepository.save(n);
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Long id) {

		try {

			narudzbenicaRepository.deleteById(id);
			return true;
			
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}
}
