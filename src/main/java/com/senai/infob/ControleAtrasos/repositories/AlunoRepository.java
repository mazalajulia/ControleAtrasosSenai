package com.senai.infob.ControleAtrasos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senai.infob.ControleAtrasos.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    @Query(value="select * from usuario where email = email", nativeQuery = true)
    public Aluno findByEmail(String email);
}