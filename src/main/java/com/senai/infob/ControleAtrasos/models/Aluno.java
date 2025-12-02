package com.senai.infob.ControleAtrasos.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="aluno")
public class Aluno {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome_completo")
    private String nomeCompleto;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "email")
    private String email;
          
    @Column(name = "senha")
    private String senha;

     @Column(name = "turma")
    private String turma;

     public Aluno() {
     }

     public Aluno(Integer id, String nomeCompleto, String cpf, LocalDate dataNascimento, String email, String senha,
            String turma) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
        this.turma = turma;
     }

     public Integer getId() {
         return id;
     }

     public void setId(Integer id) {
         this.id = id;
     }

     public String getNomeCompleto() {
         return nomeCompleto;
     }

     public void setNomeCompleto(String nomeCompleto) {
         this.nomeCompleto = nomeCompleto;
     }

     public String getCpf() {
         return cpf;
     }

     public void setCpf(String cpf) {
         this.cpf = cpf;
     }

     public LocalDate getDataNascimento() {
         return dataNascimento;
     }

     public void setDataNascimento(LocalDate dataNascimento) {
         this.dataNascimento = dataNascimento;
     }

     public String getEmail() {
         return email;
     }

     public void setEmail(String email) {
         this.email = email;
     }

     public String getSenha() {
         return senha;
     }

     public void setSenha(String senha) {
         this.senha = senha;
     }

     public String getTurma() {
         return turma;
     }

     public void setTurma(String turma) {
         this.turma = turma;
     }

    
     
}