package com.example.sistassinaturas.aplicacao.casosDeUso;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.sistassinaturas.aplicacao.dtos.ClienteDTO;
import com.example.sistassinaturas.dominio.entidades.ClienteModel;
import com.example.sistassinaturas.dominio.servicos.ServicoDeCliente;

@Component
public class ListarClientesUC {
    private final ServicoDeCliente clienteServico;

    public ListarClientesUC(ServicoDeCliente clienteServico) {
        this.clienteServico = clienteServico;
    }

    public List<ClienteDTO> executar() {
        List<ClienteModel> clientes = clienteServico.listarTodos();
        return clientes.stream()
            .map(cliente -> new ClienteDTO(cliente.getCodigo(), cliente.getNome(), cliente.getEmail()))
            .collect(Collectors.toList());
    }
}
