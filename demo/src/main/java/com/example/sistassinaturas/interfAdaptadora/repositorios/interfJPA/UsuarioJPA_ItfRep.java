package com.example.sistassinaturas.interfAdaptadora.repositorios.interfJPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistassinaturas.interfAdaptadora.repositorios.entidades.Usuario;

public interface UsuarioJPA_ItfRep extends JpaRepository<Usuario, String> {
}