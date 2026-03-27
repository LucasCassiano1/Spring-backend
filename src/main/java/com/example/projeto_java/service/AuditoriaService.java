package com.example.projeto_java.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.projeto_java.entity.Auditoria;
import com.example.projeto_java.repository.AuditoriaRepository;

@Service
public class AuditoriaService {

    @Autowired
    private AuditoriaRepository auditoriaRepo;

    public Auditoria novaAuditoria(Auditoria auditoria) {
        // Valida nome novo
        if(auditoria.getNomeNovo() == null ||
           auditoria.getNomeNovo().equals(auditoria.getNomeAntigo())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "Nome novo deve ser diferente do nome antigo!");
        }
        if(auditoria.getNomeNovo().length() <= 8) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "Nome novo deve ter mais de 8 caracteres!");
        }
        if(!auditoria.getNomeNovo().startsWith("ROLE_")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "Nome novo deve iniciar com ROLE_!");
        }
        // Valida risco se informado
        if(auditoria.getRisco() != null) {
            if(auditoria.getRisco().compareTo(BigDecimal.ZERO) < 0 ||
               auditoria.getRisco().compareTo(BigDecimal.TEN) > 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Risco deve ser entre 0 e 10!");
            }
        }
        // Preenche data/hora atual se não informada
        if(auditoria.getDataHora() == null) {
            auditoria.setDataHora(LocalDateTime.now());
        }
        return auditoriaRepo.save(auditoria);
    }

    public List<Auditoria> buscarTodos() {
        return auditoriaRepo.findAll();
    }

    public List<Auditoria> buscarPorNomeAntigoENomeAutorizacao(
            String nomeAntigo, String nomeAutorizacao) {
        if(nomeAntigo == null || nomeAutorizacao == null ||
           nomeAntigo.isBlank() || nomeAutorizacao.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "Nome antigo e nome da autorização são obrigatórios!");
        }
        return auditoriaRepo.findByNomeAntigoContainsAndAutorizacaoNome(
            nomeAntigo, nomeAutorizacao);
    }
}