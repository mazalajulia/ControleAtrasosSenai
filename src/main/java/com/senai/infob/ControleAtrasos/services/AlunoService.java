package com.senai.infob.ControleAtrasos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infob.ControleAtrasos.models.Aluno;
import com.senai.infob.ControleAtrasos.repositories.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

 
    public Aluno cadastrarUsuario(Aluno aluno, String confirmarSenha, String senha) {
        if (!senha.equals(confirmarSenha)) {
            return null;
        }

        alunoRepository.save(aluno);
        return aluno;
    }

    public Aluno login(String email, String senha) {
        Aluno aluno = alunoRepository.findByEmail(email);

        if (aluno == null) {
            System.out.println("Usuário não encontrado!");
            return null;
        }

        if (!aluno.getSenha().equals(senha)) {
            System.out.println("Senha incorreta!");
            return null;
        }

        return aluno;
    }
    
    public boolean atualizar(Aluno aluno, Integer id) {
        Aluno usu = alunoRepository.findById(id).get();
        if (usu != null) {
            aluno.setId(id);
            alunoRepository.save(aluno);
            return true;
        }
        return false;
    }
}
