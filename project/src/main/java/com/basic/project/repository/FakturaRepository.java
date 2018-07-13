package com.basic.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basic.project.domain.Faktura;

@Repository
public interface FakturaRepository extends JpaRepository<Faktura, Long> {

}
