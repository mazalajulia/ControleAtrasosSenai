package com.senai.infob.ControleAtrasos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infob.ControleAtrasos.models.Aluno;
import com.senai.infob.ControleAtrasos.models.Atraso;
import com.senai.infob.ControleAtrasos.services.AlunoService;

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
    public Aluno cadastro(@RequestBody Aluno aluno, @RequestParam String confirmarSenha, @RequestParam String senha) {
        return alunoService.cadastrarUsuario(aluno, confirmarSenha, senha);
    }
    @PutMapping("/atualizar/{id}")
    public Aluno atualizar(@PathVariable Integer id, @RequestBody Aluno aluno) {
        if(alunoService.atualizar(aluno, id)) {
            return aluno;
        }
        return null;
    }
     @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Integer id) {
        Boolean deletou = alunoService.delete(id);
        if (deletou) {
            return "Aluno removido com sucesso";
        }
        return "Falha ao remover o aluno";
    }

       @GetMapping("/listar")
    public List<Aluno> listarTodos() {
        return alunoService.listarTodos();
    }
      @GetMapping("/buscar/{id}")
    public Aluno buscarPorId(@PathVariable Integer id) {
        return alunoService.buscarPorId(id);
    }
}