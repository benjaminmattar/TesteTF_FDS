package com.example.sistassinaturas.interfAdaptadora.repositorios.implemRepositorios;

import org.springframework.stereotype.Repository;

import com.example.sistassinaturas.dominio.entidades.ClienteModel;
import com.example.sistassinaturas.dominio.interfRepositorios.IClienteRepositorio;
import com.example.sistassinaturas.interfAdaptadora.repositorios.interfJPA.ClienteJPA_ItfRep;
import com.example.sistassinaturas.interfAdaptadora.repositorios.entidades.Cliente;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ClienteRepJPA implements IClienteRepositorio {

    private final ClienteJPA_ItfRep clienteJPA;

    public ClienteRepJPA(ClienteJPA_ItfRep clienteJPA) {
        this.clienteJPA = clienteJPA;
    }

    @Override
    public ClienteModel save(ClienteModel clienteModel) {
        Cliente cliente = new Cliente(clienteModel.getCodigo(), clienteModel.getNome(), clienteModel.getEmail());
        Cliente savedCliente = clienteJPA.save(cliente);
        return new ClienteModel(savedCliente.getCodigo(), savedCliente.getNome(), savedCliente.getEmail());
    }

    @Override
    public ClienteModel findById(Long id) {
        Cliente cliente = clienteJPA.findById(id).orElse(null);
        if (cliente == null) {
            return null;
        }
        return new ClienteModel(cliente.getCodigo(), cliente.getNome(), cliente.getEmail());
    }

    @Override
    public List<ClienteModel> findAll() {
        return clienteJPA.findAll().stream()
                .map(cliente -> new ClienteModel(cliente.getCodigo(), cliente.getNome(), cliente.getEmail()))
                .collect(Collectors.toList());
    }

    @Override
    public void update(ClienteModel clienteModel) {
        Cliente cliente = new Cliente(clienteModel.getCodigo(), clienteModel.getNome(), clienteModel.getEmail());
        clienteJPA.save(cliente);
    }
}
