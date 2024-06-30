package com.example.sistassinaturas.dominio.interfRepositorios;

import com.example.sistassinaturas.dominio.entidades.UsuarioModel;

public interface IUsuarioRepositorio {
    UsuarioModel save(UsuarioModel usuario);
    UsuarioModel findByUsuario(String usuario);
}
