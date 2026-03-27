package com.example.projeto_java.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.projeto_java.entity.Auditoria;
import com.example.projeto_java.service.AuditoriaService;

@RestController
@CrossOrigin
@RequestMapping(value = "/auditoria")
public class AuditoriaController {

    @Autowired
    private AuditoriaService service;

    @PostMapping
    public Auditoria novaAuditoria(@RequestBody Auditoria auditoria) {
        return service.novaAuditoria(auditoria);
    }

    @GetMapping
    public List<Auditoria> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping(value = "/buscar")
    public List<Auditoria> buscarPorNomeAntigoENomeAutorizacao(
            @RequestParam String nomeAntigo,
            @RequestParam String nomeAutorizacao) {
        return service.buscarPorNomeAntigoENomeAutorizacao(nomeAntigo, nomeAutorizacao);
    }
}