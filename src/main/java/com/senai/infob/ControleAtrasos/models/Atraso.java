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

    @Column(name = "hora")
    private LocalDateTime cpf;

    @Column(name = "quantidade")
    private Integer quantidade;
    
    @ManyToOne
    @JoinColumn(name = "atraso_id", nullable = false)
    private Atraso atraso;

    public Atraso() {
    }

    public Atraso(Integer id, LocalDate data, LocalDateTime cpf, Integer quantidade, Atraso atraso) {
        this.id = id;
        this.data = data;
        this.cpf = cpf;
        this.quantidade = quantidade;
        this.atraso = atraso;
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

    public LocalDateTime getCpf() {
        return cpf;
    }

    public void setCpf(LocalDateTime cpf) {
        this.cpf = cpf;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Atraso getAtraso() {
        return atraso;
    }

    public void setAtraso(Atraso atraso) {
        this.atraso = atraso;
    }

    
}