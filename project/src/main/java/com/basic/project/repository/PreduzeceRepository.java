package com.basic.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basic.project.domain.Preduzece;

@Repository
public interface PreduzeceRepository extends JpaRepository<Preduzece, Long> {

}
