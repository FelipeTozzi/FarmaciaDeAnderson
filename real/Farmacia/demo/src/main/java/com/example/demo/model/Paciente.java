package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_paciente;
    @Column
    private String nome;
    @NotNull
    @Size(min = 11, max = 14)
    @Column(nullable = false)
    private String cpf;

    @NotNull
    @Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern ="yyyy-MM-dd")
    private Date nascimento;
    @Column
    private String planoDeSaude;

    public Paciente(String nome, String cpf, Date nascimento, String planoDeSaude) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.planoDeSaude = planoDeSaude;
    }

    public Paciente() {

    }


    public long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getPlanoDeSaude() {
        return planoDeSaude;
    }

    public void setPlanoDeSaude(String planoDeSaude) {
        this.planoDeSaude = planoDeSaude;
    }
}
