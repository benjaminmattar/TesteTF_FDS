package com.example.sistassinaturas.interfAdaptadora.repositorios.interfJPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistassinaturas.interfAdaptadora.repositorios.entidades.Aplicativo;

public interface AplicativoJPA_ItfRep extends JpaRepository<Aplicativo, Long> {

}
