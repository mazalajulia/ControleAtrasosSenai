package com.senai.infob.ControleAtrasos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senai.infob.ControleAtrasos.models.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    @Query(value="select * from funcionario where email = email", nativeQuery = true)
    public Funcionario findByEmail(String email);
}