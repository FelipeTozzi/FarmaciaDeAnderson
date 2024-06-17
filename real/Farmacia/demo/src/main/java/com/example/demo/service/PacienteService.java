package com.example.demo.service;

import com.example.demo.model.Paciente;
import com.example.demo.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente criar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente atualizar(Paciente paciente, Long id_paciente) {
        if(verificaID(id_paciente)) {
            //verdadeiro
            paciente.setId_paciente(id_paciente);
            return pacienteRepository.save(paciente);
        }
        return null;
    }

    private boolean verificaID(Long id_paciente) {
        if(pacienteRepository.existsById(id_paciente)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deletar(Long id_paciente) {
        if(verificaID(id_paciente)) {
            pacienteRepository.deleteById(id_paciente);
            return true;
        } else {
            return false;
        }
    }

    public int qtdPacientes() {
        return pacienteRepository.findAll().size();
    }

    public Optional<Paciente> buscaPorID(Long id) {
        return pacienteRepository.findById(id);
    }
}