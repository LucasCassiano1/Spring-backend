package com.example.projeto_java.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projeto_java.entity.Trabalho;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {

    public List<Trabalho> findByTituloContainsAndUsuarioNomeContains(
        String titulo, String nomeUsuario);
}