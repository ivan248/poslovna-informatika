package com.basic.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basic.project.domain.Adresa;

@Repository
public interface AdresaRepository extends JpaRepository<Adresa, Long	> {

}
