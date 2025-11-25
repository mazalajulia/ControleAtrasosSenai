package com.senai.infob.ControleAtrasos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infob.ControleAtrasos.models.Aluno;
import com.senai.infob.ControleAtrasos.services.AlunoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    
    @Autowired
    public AlunoService alunoService;
    
    
    @PostMapping("/login")
    public Aluno login(@RequestParam String email,@RequestParam String senha) {
        return alunoService.login(email, senha);
    }
    
    @PostMapping("/cadastro")
    public Aluno cadastro(@RequestBody Aluno aluno, @RequestParam String confirmarSenha) {
        return alunoService.cadastrarUsuario(aluno, confirmarSenha);
    }
    @PutMapping("/atualizar/{id}")
    public Aluno atualizar(@PathVariable Integer id, @RequestBody Aluno aluno) {
        if(alunoService.atualizar(aluno, id)) {
            return aluno;
        }
        return null;
    }


}