package com.example.sistassinaturas.dominio.servicos;

import com.example.sistassinaturas.dominio.entidades.PagamentoModel;
import com.example.sistassinaturas.dominio.interfRepositorios.IPagamentoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoDePagamento {

    private final IPagamentoRepositorio pagamentoRepositorio;

    public ServicoDePagamento(IPagamentoRepositorio pagamentoRepositorio) {
        this.pagamentoRepositorio = pagamentoRepositorio;
    }

    public PagamentoModel registrarPagamento(PagamentoModel pagamento) {
        return pagamentoRepositorio.save(pagamento);
    }

    public List<PagamentoModel> listarTodos() {
        return pagamentoRepositorio.findAll();
    }
}
