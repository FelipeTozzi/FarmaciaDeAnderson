package com.example.demo.service;

import com.example.demo.model.Medicamento;
import com.example.demo.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService {

    @Autowired
    MedicamentoRepository medicamentoRepository;

    public List<Medicamento>listarMedicamentos(){
        return medicamentoRepository.findAll();
    }

    public Medicamento criar (Medicamento medicamento){
        return medicamentoRepository.save(medicamento);
    }

    public Medicamento atualizar(Medicamento medicamento, Long id_medicamento){
        if(verificaID(id_medicamento)) {
            medicamento.setId_medicamento(id_medicamento);
            return medicamentoRepository.save(medicamento);

        } return null;
    }

    private boolean verificaID(Long id_medicamento){
        if(medicamentoRepository.existsById(id_medicamento)) {
            return true;
        }else{
            return false;
        }
    }

    public boolean deletar(Long id_medicamento){
        if(verificaID(id_medicamento)) {
            medicamentoRepository.deleteById(id_medicamento);
            return true;
        }else{
            return false;
        }
    }

    public int qtdMedicamentos(){
        return medicamentoRepository.findAll().size();
    }

    public Optional<Medicamento>buscaPorID(Long id_medicamento){
        return medicamentoRepository.findById(id_medicamento);
    }




}
