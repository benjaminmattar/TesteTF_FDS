package com.example.sistassinaturas.dominio.interfRepositorios;

import java.util.List;

import com.example.sistassinaturas.dominio.entidades.ClienteModel;

public interface IClienteRepositorio {
    List<ClienteModel> findAll();
    ClienteModel findById(Long id);
    ClienteModel save(ClienteModel cliente);
    void update(ClienteModel cliente);
}
