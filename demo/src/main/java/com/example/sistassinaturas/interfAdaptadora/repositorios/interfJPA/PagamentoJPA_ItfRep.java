package com.example.sistassinaturas.interfAdaptadora.repositorios.interfJPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistassinaturas.interfAdaptadora.repositorios.entidades.Pagamento;

public interface PagamentoJPA_ItfRep extends JpaRepository<Pagamento, Long> {
}
