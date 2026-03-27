package com.example.projeto_java.service;

import java.util.List;
import com.example.projeto_java.entity.Usuario;

public interface IUsuarioService {
    public Usuario buscarPorId(Long id);
    public Usuario novoUsuario(Usuario usuario);
    public List<Usuario> buscarTodos();
}
