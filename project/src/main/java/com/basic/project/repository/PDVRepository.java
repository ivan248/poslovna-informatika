package com.basic.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basic.project.domain.PDV;

@Repository
public interface PDVRepository extends JpaRepository<PDV, Long>{

}
