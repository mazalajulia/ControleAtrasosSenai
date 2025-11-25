package com.senai.infob.ControleAtrasos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infob.ControleAtrasos.models.Aluno;
import com.senai.infob.ControleAtrasos.repositories.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

 
    public Aluno cadastrarUsuario(Aluno usuario, String confirmarSenha) {
        if (!usuario.getSenha().equals(confirmarSenha)) {
            return null;
        }

        alunoRepository.save(usuario);
        return usuario;
    }

    public Aluno login(String email, String senha) {
        Aluno usuario = alunoRepository.findByEmail(email);

        if (usuario == null) {
            System.out.println("Usuário não encontrado!");
            return null;
        }

        if (!usuario.getSenha().equals(senha)) {
            System.out.println("Senha incorreta!");
            return null;
        }

        return usuario;
    }
    
    public boolean atualizar(Aluno usuario, Integer id) {
        Aluno usu = alunoRepository.findById(id).get();
        if (usu != null) {
            usuario.setId(id);
            alunoRepository.save(usuario);
            return true;
        }
        return false;
    }
}
