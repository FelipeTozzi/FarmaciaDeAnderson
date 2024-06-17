package com.example.demo.service;

import com.example.demo.model.Medico;
import com.example.demo.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    public List<Medico> listarFuncionarios() {
        return medicoRepository.findAll();
    }

    public Medico criar(Medico medico) {
        return medicoRepository.save(medico);
    }

    public Medico atualizar(Medico medico, Long id_medico) {
        if(verificaID(id_medico)) {
            //verdadeiro
            medico.setId_medico(id_medico);
            return medicoRepository.save(medico);
        }
        return null;
    }

    private boolean verificaID(Long id_medico) {
        if(medicoRepository.existsById(id_medico)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deletar(Long id_medico) {
        if(verificaID(id_medico)) {
            medicoRepository.deleteById(id_medico);
            return true;
        } else {
            return false;
        }
    }

    public int qtdMedicos() {
        return medicoRepository.findAll().size();
    }

    public Optional<Medico> buscaPorID(Long id) {
        return medicoRepository.findById(id);
    }
}