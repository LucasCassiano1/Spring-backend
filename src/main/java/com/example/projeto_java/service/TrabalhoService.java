package com.example.projeto_java.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.projeto_java.entity.Trabalho;
import com.example.projeto_java.repository.TrabalhoRepository;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepo;

    public Trabalho novoTrabalho(Trabalho trabalho) {
        if(trabalho.getTitulo() == null || trabalho.getUsuario() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
                "Título e usuário são obrigatórios!");
        }
        if(trabalho.getDataHoraEntrega() == null) {
            trabalho.setDataHoraEntrega(LocalDateTime.now());
        }
        return trabalhoRepo.save(trabalho);
    }

    public List<Trabalho> buscarTodos() {
        return trabalhoRepo.findAll();
    }

    public List<Trabalho> buscarPorTituloENomeUsuario(String titulo, String nomeUsuario) {
        return trabalhoRepo.findByTituloContainsAndUsuarioNomeContains(titulo, nomeUsuario);
    }
}