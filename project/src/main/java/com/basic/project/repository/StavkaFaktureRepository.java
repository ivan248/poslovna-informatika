package com.basic.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basic.project.domain.StavkaFakture;

@Repository
public interface StavkaFaktureRepository extends JpaRepository<StavkaFakture, Long> {

}
