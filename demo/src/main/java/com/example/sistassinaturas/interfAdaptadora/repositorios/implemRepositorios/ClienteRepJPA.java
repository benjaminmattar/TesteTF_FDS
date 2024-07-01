package com.example.sistassinaturas.interfAdaptadora.repositorios.implemRepositorios;

import org.springframework.stereotype.Repository;

import com.example.sistassinaturas.dominio.entidades.ClienteModel;
import com.example.sistassinaturas.dominio.interfRepositorios.IClienteRepositorio;
import com.example.sistassinaturas.interfAdaptadora.repositorios.interfJPA.ClienteJPA_ItfRep;
import com.example.sistassinaturas.interfAdaptadora.repositorios.entidades.Cliente;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class ClienteRepJPA implements IClienteRepositorio {

    private final ClienteJPA_ItfRep clienteJPA;
    private final AtomicLong currentId = new AtomicLong(10); // Inicializando com 10 para os IDs iniciais

    public ClienteRepJPA(ClienteJPA_ItfRep clienteJPA) {
        this.clienteJPA = clienteJPA;

        // Inicializar banco de dados com 10 clientes se estiver vazio
        if (clienteJPA.count() == 0) {
            clienteJPA.save(new Cliente(1L, "Alice Johnson", "alice.johnson@example.com"));
            clienteJPA.save(new Cliente(2L, "Bob Smith", "bob.smith@example.com"));
            clienteJPA.save(new Cliente(3L, "Charlie Brown", "charlie.brown@example.com"));
            clienteJPA.save(new Cliente(4L, "David Wilson", "david.wilson@example.com"));
            clienteJPA.save(new Cliente(5L, "Eve Davis", "eve.davis@example.com"));
            clienteJPA.save(new Cliente(6L, "Frank Miller", "frank.miller@example.com"));
            clienteJPA.save(new Cliente(7L, "Grace Lee", "grace.lee@example.com"));
            clienteJPA.save(new Cliente(8L, "Hannah Moore", "hannah.moore@example.com"));
            clienteJPA.save(new Cliente(9L, "Ivy White", "ivy.white@example.com"));
            clienteJPA.save(new Cliente(10L, "Jack Black", "jack.black@example.com"));
        } else {
            // Definir o contador para o próximo valor após os IDs existentes
            long maxId = clienteJPA.findAll().stream()
                    .mapToLong(Cliente::getCodigo)
                    .max()
                    .orElse(10L);
            currentId.set(maxId);
        }
    }

    @Override
    public ClienteModel save(ClienteModel clienteModel) {
        if (clienteModel.getCodigo() == null) {
            clienteModel.setCodigo(currentId.incrementAndGet());
        }
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
