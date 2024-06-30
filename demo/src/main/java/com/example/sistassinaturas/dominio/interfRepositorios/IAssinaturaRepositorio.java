package com.example.sistassinaturas.dominio.interfRepositorios;

import java.util.List;

import com.example.sistassinaturas.dominio.entidades.AssinaturaModel;

public interface IAssinaturaRepositorio {
    List<AssinaturaModel> findAll();
    AssinaturaModel findById(Long id);
    AssinaturaModel save(AssinaturaModel assinatura);
    void update(AssinaturaModel assinatura);
    List<AssinaturaModel> findByCliente(Long codigoCliente);
    List<AssinaturaModel> findByAplicativo(Long codigoAplicativo);
}
