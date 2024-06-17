package com.example.demo.controller;

import com.example.demo.model.Farmacia;
import com.example.demo.repository.FarmaciaRepository;
import com.example.demo.service.FarmaciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/farmacia")
public class FarmaciaController {

    @Autowired
    FarmaciaService farmaciaService;

    @GetMapping
    public List<Farmacia> listarFarmacia() {
        return farmaciaService.ListarFarmacia();
    }

    @PostMapping
    public Farmacia criar(@Valid @RequestBody Farmacia farmacia) {
        return farmaciaService.criar(farmacia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Farmacia farmacia, @PathVariable Long id) {
        //return funcionarioService.atualizar(funcionario, id);
        if(farmaciaService.atualizar(farmacia, id) == null) {
            //O id não foi encontrado
            //return ResponseEntity.notFound().build();
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            //O id foi encontrado
            return ResponseEntity.ok(farmacia);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(farmaciaService.deletar(id)) {
            String mensagem = "O id " + id + " foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        } else {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @GetMapping("/qtd")
    public int qtdFarmacias() {
        return farmaciaService.qtdFarmacias();
    }

    @GetMapping("/{id}")
    public Optional<Farmacia> buscarPorID(@PathVariable Long id) {
        return farmaciaService.buscaPorID(id);
    }

}
