package com.example.sistassinaturas.dominio.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sistassinaturas.dominio.entidades.ClienteModel;
import com.example.sistassinaturas.dominio.interfRepositorios.IClienteRepositorio;

@Service
public class ServicoDeCliente {
    private final IClienteRepositorio clienteRepositorio;

    public ServicoDeCliente(IClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    public List<ClienteModel> listarTodos() {
        return clienteRepositorio.findAll();
    }
}
