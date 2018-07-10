package com.basic.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basic.project.domain.GrupaProizvoda;

@Repository
public interface GrupaProizvodaRepository extends JpaRepository<GrupaProizvoda, Long> {

	public GrupaProizvoda findOneByNazivGrupeProizvoda(String nazivGrupeProizvoda);
}
