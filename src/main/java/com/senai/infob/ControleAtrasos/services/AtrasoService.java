package com.senai.infob.ControleAtrasos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infob.ControleAtrasos.models.Atraso;
import com.senai.infob.ControleAtrasos.repositories.AtrasoRepository;

@Service
public class AtrasoService{
    
    @Autowired
    private AtrasoRepository atrasoRepository;

   public long count() {
        return atrasoRepository.count();
    }

    public Atraso salvar(Atraso atraso) {
        return atrasoRepository.save(atraso);
    }

    public Boolean  delete(Integer id) {
        Atraso atraso = atrasoRepository.findById(id).get();
        if(atraso != null) {
            atrasoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Atraso buscarPorId(Integer id) {
        return atrasoRepository.findById(id).orElse(null);
    }
    
    public List<Atraso> listarTodos() {
        return atrasoRepository.findAll();
    }

 public boolean atualizar(Atraso atraso, Integer id) {
    Atraso existente = buscarPorId(id);

    if (existente != null) {
        atraso.setId(id);
        atrasoRepository.save(atraso);
        return true;
    }

    return false;
}
}