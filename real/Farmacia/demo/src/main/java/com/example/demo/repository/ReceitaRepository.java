package com.example.demo.repository;

import com.example.demo.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Long>{
}
