package com.example.sistassinaturas.interfAdaptadora.repositorios.interfJPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistassinaturas.interfAdaptadora.repositorios.entidades.Cliente;

public interface ClienteJPA_ItfRep extends JpaRepository<Cliente, Long> {
}