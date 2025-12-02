package com.senai.infob.ControleAtrasos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infob.ControleAtrasos.models.Funcionario;
import com.senai.infob.ControleAtrasos.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario cadastrarUsuario(Funcionario funcionario, String confirmarSenha, String senha) {
        if (!senha.equals(confirmarSenha)) {
            return null;
        }

        funcionarioRepository.save(funcionario);
        return funcionario;
    }

    public Boolean  delete(Integer id) {
        Funcionario funcionario = funcionarioRepository.findById(id).get();
        if(funcionario != null) {
            funcionarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Funcionario login(String email, String senha) {
        Funcionario funcionario = funcionarioRepository.findByEmail(email);

        if (funcionario == null) {
            System.out.println("Usuário não encontrado!");
            return null;
        }

        if (!funcionario.getSenha().equals(senha)) {
            System.out.println("Senha incorreta!");
            return null;
        }

        return funcionario;
    }
    
    public boolean atualizar(Funcionario funcionario, Integer id) {
        Funcionario alu = funcionarioRepository.findById(id).get();
        if (alu != null) {
            funcionario .setId(id);
            funcionarioRepository.save(funcionario);
            return true;
        }
        return false;
    }

     public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarPorId(Integer id) {
    return funcionarioRepository.findById(id).orElse(null);
}

   
}
