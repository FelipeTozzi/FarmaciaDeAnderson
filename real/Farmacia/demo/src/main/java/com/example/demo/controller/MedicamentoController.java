package com.example.demo.controller;

import com.example.demo.model.Medicamento;
import com.example.demo.repository.MedicamentoRepository;
import com.example.demo.service.MedicamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicamentos")

public class MedicamentoController {

    @Autowired
    MedicamentoService medicamentoService;

    @GetMapping
    public List<Medicamento>listarMedicamentos(){
        return medicamentoService.listarMedicamentos();
    }

    @PostMapping
    public Medicamento criar(@Valid @RequestBody Medicamento medicamento){
        return medicamentoService.criar(medicamento);
    }

    @PutMapping("/id")
    public ResponseEntity<?>atualizar(@RequestBody Medicamento medicamento, @PathVariable Long id_medicamento){
        if(medicamentoService.atualizar(medicamento, id_medicamento) == null){
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            //O id foi encontrado
            return ResponseEntity.ok(medicamento);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deletar(@PathVariable Long id_medicamento){
        if(medicamentoService.deletar(id_medicamento)){
            String mensagem = "O id " + id_medicamento + " foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        } else {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @GetMapping("/qtd")
    public int qtdMedicamentos(){
        return medicamentoService.qtdMedicamentos();
    }

    @GetMapping("/{id}")
    public Optional<Medicamento>buscaPorID(@PathVariable Long id_medicamento){
        return medicamentoService.buscaPorID(id_medicamento);
    }
}
