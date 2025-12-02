package com.senai.infob.ControleAtrasos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infob.ControleAtrasos.models.Atraso;
import com.senai.infob.ControleAtrasos.services.AtrasoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/atraso")
public class AtrasoController {
    
    @Autowired
    public AtrasoService atrasoService;

    @PostMapping("/salvar")
    public Atraso salvar(@RequestBody Atraso atraso) {
        return atrasoService.salvar(atraso);
    }

    @PutMapping("/atualizar/{id}")
    public Atraso atualizar(@PathVariable Integer id, @RequestBody Atraso atraso) {
        if(atrasoService.atualizar(atraso, id)) {
            return atraso;
        }
        return null;
    }
    
     @GetMapping("/buscar/{id}")
    public Atraso buscarPorId(@PathVariable Integer id) {
        return atrasoService.buscarPorId(id);
    }

       @GetMapping("/listar")
    public List<Atraso> listarTodos() {
        return atrasoService.listarTodos();
    }

     @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Integer id) {
        Boolean deletou = atrasoService.delete(id);
        if (deletou) {
            return "Atraso removido com sucesso";
        }
        return "Falha ao remover o atraso";
    }

}