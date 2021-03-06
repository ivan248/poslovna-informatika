package com.basic.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basic.project.domain.Narudzbenica;

@Repository
public interface NarudzbenicaRepository extends JpaRepository<Narudzbenica, Long> {

}
