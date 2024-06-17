package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public class Farmacia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_farmacia;
    @Column
    private String nome;

    @NotNull
    @Size(min = 14, max = 14)
    @Column(nullable = false)
    private String cnpj;
    @Column
    private String senha;
    @NotNull
    @Size(min = 1, max = 99)
    @Column(nullable = false)
    private String local;


    public Farmacia() {
    }


    public Farmacia(String nome, String cnpj, String senha, String local) {

        this.nome = nome;
        this.cnpj = cnpj;
        this.senha = senha;
        this.local = local;
    }

    public long getId_farmacia() {
        return id_farmacia;
    }

    public void setId_farmacia(long id_farmacia) {
        this.id_farmacia = id_farmacia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}