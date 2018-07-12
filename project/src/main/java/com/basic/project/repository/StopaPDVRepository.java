package com.basic.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basic.project.domain.StopaPDV;

@Repository
public interface StopaPDVRepository  extends JpaRepository<StopaPDV, Long>{

}
