package com.basic.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basic.project.domain.Cenovnik;

@Repository
public interface CenovnikRepository extends JpaRepository<Cenovnik,Long> {

}
