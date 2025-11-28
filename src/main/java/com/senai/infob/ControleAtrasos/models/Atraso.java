package com.senai.infob.ControleAtrasos.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="atraso")
public class Atraso {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "quantidade")
    private Integer quantidade;
    
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

        public Atraso() {
        }
    
        public Atraso(Integer id, LocalDate data, String cpf, Integer quantidade, Aluno aluno) {
            this.id = id;
            this.data = data;
            this.cpf = cpf;
            this.quantidade = quantidade;
            this.aluno = aluno;
        }
    
        public Integer getId() {
            return id;
        }
    
        public void setId(Integer id) {
            this.id = id;
        }
    
        public LocalDate getData() {
            return data;
        }
    
        public void setData(LocalDate data) {
            this.data = data;
        }
    
        public String getCpf() {
            return cpf;
        }
}