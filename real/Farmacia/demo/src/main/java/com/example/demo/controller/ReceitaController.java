package com.example.demo.controller;

import com.example.demo.model.Receita;
import com.example.demo.repository.ReceitaRepository;
import com.example.demo.service.ReceitaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    @Autowired
    ReceitaService receitaService;

    @GetMapping
    public List<Receita> listarReceitas() {
        return receitaService.listarReceitas();
    }

    @PostMapping
    public Receita criar(@Valid @RequestBody Receita medico) {
        return receitaService.criar(medico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Receita receita, @PathVariable Long id) {
        if(receitaService.atualizar(receita, id) == null) {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(receita);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(receitaService.deletar(id)) {
            String mensagem = "O id " + id + " foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        } else {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @GetMapping("/qtd")
    public int qtdReceitas() {
        return receitaService.qtdReceitas();
    }

    @GetMapping("/{id}")
    public Optional<Receita> buscarPorID(@PathVariable Long id) {
        return receitaService.buscaPorID(id);
    }

}
