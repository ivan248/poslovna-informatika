package com.basic.project.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.project.domain.JedinicaMere;
import com.basic.project.domain.Proizvod;
import com.basic.project.repository.JedinicaMereRepository;
import com.basic.project.repository.ProizvodRepository;
import com.basic.project.service.JedinicaMereService;

@Service
public class JedinicaMereServiceImpl implements JedinicaMereService {

	@Autowired
	private ProizvodRepository proizvodRepository;

	@Autowired
	private JedinicaMereRepository jedinicaMereRepository;

	@Override
	public List<JedinicaMere> getAll() {

		return jedinicaMereRepository.findAll();
	}

	@Override
	public boolean add(JedinicaMere jm) {

		try {
			jedinicaMereRepository.save(jm);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public JedinicaMere getOne(Long id) {

		try {
			return jedinicaMereRepository.findById(id).get();
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean update(JedinicaMere jm) {

		try {
			
			JedinicaMere jedinicaMere = jedinicaMereRepository.getOne(jm.getId());
			
			jedinicaMere.setNazivJediniceMere(jm.getNazivJediniceMere());
			jedinicaMere.setSkracenica(jm.getSkracenica());
			
			jedinicaMereRepository.save(jedinicaMere);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(Long id) {

		try {

			for (Proizvod p : proizvodRepository.findAll()) {
				if (p.getJedinicaMere().getId() == id) {
					System.out.println("************************** WARNING **************************\n\n");
					System.out.println("Ne mozete obrisati ovu jedinicu mere. Postoji proizvod koji je sadrzi!\n\n");
					System.out.println("************************** WARNING **************************");
					return false;
				}
			}

			jedinicaMereRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
