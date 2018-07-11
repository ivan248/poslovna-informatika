package com.basic.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basic.project.domain.Cenovnik;

public interface CenovnikRepository extends JpaRepository<Cenovnik,Long> {

}
