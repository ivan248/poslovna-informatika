package com.basic.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basic.project.domain.JedinicaMere;

@Repository
public interface JedinicaMereRepository extends JpaRepository<JedinicaMere, Long> {

	public JedinicaMere findOneByNazivJediniceMere(String nazivJediniceMere);
	
}
