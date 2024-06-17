package com.example.demo.controller;

import com.example.demo.model.Medico;
import com.example.demo.repository.MedicoRepository;
import com.example.demo.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    MedicoService medicoService;

    @GetMapping
    public List<Medico> listarMedicos() {
        return medicoService.listarFuncionarios();
    }

    @PostMapping
    public Medico criar(@Valid @RequestBody Medico medico) {
        return medicoService.criar(medico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Medico medico, @PathVariable Long id) {
        if(medicoService.atualizar(medico, id) == null) {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(medico);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(medicoService.deletar(id)) {
            String mensagem = "O id " + id + " foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        } else {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @GetMapping("/qtd")
    public int qtdMedicos() {
        return medicoService.qtdMedicos();
    }

    @GetMapping("/{id}")
    public Optional<Medico> buscarPorID(@PathVariable Long id) {
        return medicoService.buscaPorID(id);
    }

}
