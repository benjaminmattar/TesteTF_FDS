package com.example.sistassinaturas.dominio.interfRepositorios;

import java.util.List;

import com.example.sistassinaturas.dominio.entidades.PagamentoModel;

public interface IPagamentoRepositorio {
    PagamentoModel save(PagamentoModel pagamento);
    PagamentoModel findById(Long id);
    List<PagamentoModel> findAll();
    void update(PagamentoModel pagamento);
}
