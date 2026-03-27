package com.example.projeto_java.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projeto_java.entity.Auditoria;

public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {

    public List<Auditoria> findByNomeAntigoContainsAndAutorizacaoNome(
        String nomeAntigo, String nomeAutorizacao);
}