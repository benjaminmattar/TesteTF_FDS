package com.example.sistassinaturas.dominio.interfRepositorios;

import java.util.List;

import com.example.sistassinaturas.dominio.entidades.AplicativoModel;

public interface IAplicativoRepositorio {
    List<AplicativoModel> findAll();
    AplicativoModel findById(Long id);
    AplicativoModel save(AplicativoModel aplicativo);
    void update(AplicativoModel aplicativo);
}
