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
import com.example.projeto_java.entity.Trabalho;
import com.example.projeto_java.service.TrabalhoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/trabalho")
public class TrabalhoController {

    @Autowired
    private TrabalhoService service;

    @PostMapping
    public Trabalho novoTrabalho(@RequestBody Trabalho trabalho) {
        return service.novoTrabalho(trabalho);
    }

    @GetMapping
    public List<Trabalho> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping(value = "/buscar")
    public List<Trabalho> buscarPorTituloENomeUsuario(
            @RequestParam String titulo,
            @RequestParam String nomeUsuario) {
        return service.buscarPorTituloENomeUsuario(titulo, nomeUsuario);
    }
}