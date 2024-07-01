package com.example.sistassinaturas.dominio.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sistassinaturas.dominio.entidades.ClienteModel;
import com.example.sistassinaturas.dominio.interfRepositorios.IClienteRepositorio;
import com.example.sistassinaturas.aplicacao.dtos.ClienteDTO;

@Service
public class ServicoDeCliente {
    private final IClienteRepositorio clienteRepositorio;

    public ServicoDeCliente(IClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    public List<ClienteModel> listarTodos() {
        return clienteRepositorio.findAll();
    }

    public ClienteModel criarCliente(ClienteDTO clienteDTO) {
        ClienteModel cliente = new ClienteModel(null, clienteDTO.getNome(), clienteDTO.getEmail());
        return clienteRepositorio.save(cliente);
    }
}
