package com.example.sistassinaturas.dominio.servicos;

import com.example.sistassinaturas.dominio.entidades.AssinaturaModel;
import com.example.sistassinaturas.dominio.entidades.PagamentoModel;
import com.example.sistassinaturas.dominio.interfRepositorios.IAssinaturaRepositorio;
import com.example.sistassinaturas.dominio.interfRepositorios.IPagamentoRepositorio;
import org.springframework.stereotype.Service;

@Service
public class ServicoDePagamento {

    private final IPagamentoRepositorio pagamentoRepositorio;
    private final IAssinaturaRepositorio assinaturaRepositorio;

    public ServicoDePagamento(IPagamentoRepositorio pagamentoRepositorio, IAssinaturaRepositorio assinaturaRepositorio) {
        this.pagamentoRepositorio = pagamentoRepositorio;
        this.assinaturaRepositorio = assinaturaRepositorio;
    }

    public PagamentoModel registrarPagamento(PagamentoModel pagamentoModel) {
        AssinaturaModel assinatura = assinaturaRepositorio.findById(pagamentoModel.getAssinatura().getCodigo());

        if (assinatura == null) {
            throw new IllegalArgumentException("Assinatura não encontrada");
        }

        pagamentoModel.setAssinatura(assinatura);
        return pagamentoRepositorio.save(pagamentoModel);
    }
}
