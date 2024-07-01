package com.example.sistassinaturas.interfAdaptadora.controladores;

import com.example.sistassinaturas.aplicacao.dtos.ClienteDTO;
import com.example.sistassinaturas.dominio.entidades.ClienteModel;
import com.example.sistassinaturas.dominio.servicos.ServicoDeCliente;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/servcad/clientes")
public class ClienteController {

    private final ServicoDeCliente servicoDeCliente;

    public ClienteController(ServicoDeCliente servicoDeCliente) {
        this.servicoDeCliente = servicoDeCliente;
    }

    @GetMapping
    public List<ClienteDTO> listarClientes() {
        return servicoDeCliente.listarTodos().stream()
                .map(cliente -> new ClienteDTO(cliente.getCodigo(), cliente.getNome(), cliente.getEmail()))
                .collect(Collectors.toList());
    }

    @PostMapping("/cadastrar")
    public ClienteDTO cadastrarCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteModel criado = servicoDeCliente.criarCliente(clienteDTO);
        return new ClienteDTO(criado.getCodigo(), criado.getNome(), criado.getEmail());
    }
}
