package com.senai.infob.ControleAtrasos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infob.ControleAtrasos.models.Atraso;
import com.senai.infob.ControleAtrasos.services.AtrasoService;


@RestController
@RequestMapping("/atraso")
public class AtrasoController {
    
    @Autowired
    public AtrasoService atrasoService;
    
  @PutMapping("/atualizar/{id}")
public Atraso atualizar(@PathVariable Integer id, @RequestBody Atraso atraso) {
    atrasoService.atualizar(atraso, id);
    return atraso;
}


}