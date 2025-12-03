package com.senai.infob.ControleAtrasos.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.infob.ControleAtrasos.models.Atraso;

@Repository
public interface AtrasoRepository extends JpaRepository<Atraso, Integer> {

}