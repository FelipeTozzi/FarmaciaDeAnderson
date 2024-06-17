package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_receita;
    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Medico medico;

    @ManyToMany
    @JoinTable(
            name = "Medicamento_Receita",
            joinColumns = @JoinColumn(name = "id_receita"),
            inverseJoinColumns = @JoinColumn(name = "id_medicamento")
    )
    @JsonIgnoreProperties("receitas")
    private List<Medicamento> medicamentos;

    @ManyToOne
    private Farmacia farmacia;
    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date data;

    public long getId_receita() {
        return id_receita;
    }

    public void setId_receita(long id_receita) {
        this.id_receita = id_receita;
    }
}
