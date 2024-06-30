package com.example.sistassinaturas.interfAdaptadora.repositorios.interfJPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistassinaturas.interfAdaptadora.repositorios.entidades.Assinatura;

public interface AssinaturaJPA_ItfRep extends JpaRepository<Assinatura, Long> {
    List<Assinatura> findByClienteCodigo(Long clienteCodigo);
    List<Assinatura> findByAplicativoCodigo(Long aplicativoCodigo);
}