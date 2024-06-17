package com.example.demo.service;

import com.example.demo.model.Farmacia;
import com.example.demo.repository.FarmaciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class FarmaciaService {

    @Autowired
    FarmaciaRepository farmaciaRepository;

    public List<Farmacia>ListarFarmacia(){
        return farmaciaRepository.findAll();}


    public Farmacia criar(Farmacia farmacia) {
        return farmaciaRepository.save(farmacia);
    }


    public Farmacia atualizar(Farmacia farmacia, Long id_farmacia) {
        if(verificaID(id_farmacia)) {
            //verdadeiro
            farmacia.setId_farmacia(id_farmacia);
            return farmaciaRepository.save(farmacia);
        }
        return null;
    }

    private boolean verificaID(Long id_farmacia) {
        if(farmaciaRepository.existsById(id_farmacia)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deletar(Long id_farmacia) {
        if(verificaID(id_farmacia)) {
            farmaciaRepository.deleteById(id_farmacia);
            return true;
        } else {
            return false;
        }
    }

    public int qtdFarmacias() {
        return farmaciaRepository.findAll().size();
    }

    public Optional<Farmacia> buscaPorID(Long id_farmacia) {
        return farmaciaRepository.findById(id_farmacia);
    }
}
