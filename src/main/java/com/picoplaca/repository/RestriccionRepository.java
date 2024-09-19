package com.picoplaca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.picoplaca.model.Restriccion;

@Repository
public interface RestriccionRepository extends JpaRepository<Restriccion, Integer>{

}
