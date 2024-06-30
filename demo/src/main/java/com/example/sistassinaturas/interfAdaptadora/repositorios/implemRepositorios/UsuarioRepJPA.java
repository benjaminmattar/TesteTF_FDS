package com.example.sistassinaturas.interfAdaptadora.repositorios.implemRepositorios;

import org.springframework.stereotype.Repository;

import com.example.sistassinaturas.dominio.entidades.UsuarioModel;
import com.example.sistassinaturas.dominio.interfRepositorios.IUsuarioRepositorio;
import com.example.sistassinaturas.interfAdaptadora.repositorios.interfJPA.UsuarioJPA_ItfRep;
import com.example.sistassinaturas.interfAdaptadora.repositorios.entidades.Usuario;

@Repository
public class UsuarioRepJPA implements IUsuarioRepositorio {

    private final UsuarioJPA_ItfRep usuarioJPA;

    public UsuarioRepJPA(UsuarioJPA_ItfRep usuarioJPA) {
        this.usuarioJPA = usuarioJPA;
    }

    @Override
    public UsuarioModel save(UsuarioModel usuarioModel) {
        Usuario usuario = new Usuario(usuarioModel.getUsuario(), usuarioModel.getSenha());
        Usuario savedUsuario = usuarioJPA.save(usuario);
        return new UsuarioModel(savedUsuario.getUsuario(), savedUsuario.getSenha());
    }

    @Override
    public UsuarioModel findByUsuario(String usuario) {
        Usuario foundUsuario = usuarioJPA.findById(usuario).orElse(null);
        if (foundUsuario == null) {
            return null;
        }
        return new UsuarioModel(foundUsuario.getUsuario(), foundUsuario.getSenha());
    }
}
