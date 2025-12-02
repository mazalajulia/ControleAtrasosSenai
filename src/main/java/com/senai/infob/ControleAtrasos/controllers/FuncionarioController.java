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

import com.senai.infob.ControleAtrasos.models.Funcionario;
import com.senai.infob.ControleAtrasos.services.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    
    @Autowired
    public FuncionarioService funcionarioService;
    
    
    @PostMapping("/login")
    public Funcionario login(@RequestParam String email,@RequestParam String senha) {
        return funcionarioService.login(email, senha);
    }
    
    @PostMapping("/cadastro")
    public Funcionario cadastro(@RequestBody Funcionario funcionario, @RequestParam String confirmarSenha, @RequestParam String senha) {
        return funcionarioService.cadastrarUsuario(funcionario, confirmarSenha, senha);
    }
    @PutMapping("/atualizar/{id}")
    public Funcionario atualizar(@PathVariable Integer id, @RequestBody Funcionario funcionario) {
        if(funcionarioService.atualizar(funcionario, id)) {
            return funcionario;
        }
        return null;
    }
     @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Integer id) {
        Boolean deletou = funcionarioService.delete(id);
        if (deletou) {
            return "Aluno removido com sucesso";
        }
        return "Falha ao remover o aluno";
    }

       @GetMapping("/listar")
    public List<Funcionario> listarTodos() {
        return funcionarioService.listarTodos();
    }
      @GetMapping("/buscar/{id}")
    public Funcionario buscarPorId(@PathVariable Integer id) {
        return funcionarioService.buscarPorId(id);
    }
}