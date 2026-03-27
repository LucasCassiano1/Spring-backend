package com.example.projeto_java.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projeto_java.entity.Autorizacao;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long> {
    public Optional<Autorizacao> findByNome(String nome);
}
