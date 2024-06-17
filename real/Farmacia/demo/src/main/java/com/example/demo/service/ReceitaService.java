package com.example.demo.service;

import com.example.demo.model.Receita;
import com.example.demo.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {

    @Autowired
    ReceitaRepository receitaRepository;

    public List<Receita> listarReceitas() {
        return receitaRepository.findAll();
    }

    public Receita criar(Receita receita) {
        return receitaRepository.save(receita);
    }

    public Receita atualizar(Receita receita, Long id_receita) {
        if(verificaID(id_receita)) {
            //verdadeiro
            receita.setId_receita(id_receita);
            return receitaRepository.save(receita);
        }
        return null;
    }

    private boolean verificaID(Long id_receita) {
        if(receitaRepository.existsById(id_receita)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deletar(Long id_receita) {
        if(verificaID(id_receita)) {
            receitaRepository.deleteById(id_receita);
            return true;
        } else {
            return false;
        }
    }

    public int qtdReceitas() {
        return receitaRepository.findAll().size();
    }

    public Optional<Receita> buscaPorID(Long id) {
        return receitaRepository.findById(id);
    }
}