package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_medico;
    @Column
    private String nome;
    @Column
    private String crm;
    @Column
    private String senha;
    @Column
    private String assinatura;

    public Medico(){

    }

    public Medico(String nome, String crm, String senha, String assinatura) {

        this.nome = nome;
        this.crm = crm;
        this.senha = senha;
        this.assinatura = assinatura;
    }

    public long getId_medico() {
        return id_medico;
    }

    public void setId_medico(long id_medico) {
        this.id_medico = id_medico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(String assinatura) {
        this.assinatura = assinatura;
    }
}
