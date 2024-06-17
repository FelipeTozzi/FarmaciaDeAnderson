package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)

public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_medicamento;
    @Column
    private String nome;

    @NotNull
    @Min(value = 1)
    @Column(nullable = false)
    private double dosagem;

    @NotNull
    @Min(value = 1)
    @Column
    private Double quantidade;
    @NotNull
    @Size(min = 1, max = 99)
    @Column(nullable = false)
    private String viaAdiministracao;

    @Column
    private String observacao;
    @ManyToMany(mappedBy = "medicamentos")
    @JsonIgnoreProperties("medicamentos")
    private List<Receita>receitas;

    public Medicamento(){
    }

    public Medicamento(String nome, Double dosagem, Double quantidade, String viaAdiministracao, String observacao){

        this.nome = nome;
        this.dosagem = dosagem;
        this.observacao = observacao;
        this.quantidade = quantidade;
        this.viaAdiministracao = viaAdiministracao;

    }

    public long getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(long id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDosagem() {
        return dosagem;
    }

    public void setDosagem(double dosagem) {
        this.dosagem = dosagem;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public String getViaAdiministracao() {
        return viaAdiministracao;
    }

    public void setViaAdiministracao(String viaAdiministracao) {
        this.viaAdiministracao = viaAdiministracao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
