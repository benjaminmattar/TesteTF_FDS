package com.example.sistassinaturas.interfAdaptadora.repositorios.implemRepositorios;

import org.springframework.stereotype.Repository;

import com.example.sistassinaturas.dominio.entidades.AssinaturaModel;
import com.example.sistassinaturas.dominio.entidades.PagamentoModel;
import com.example.sistassinaturas.dominio.interfRepositorios.IPagamentoRepositorio;
import com.example.sistassinaturas.interfAdaptadora.repositorios.interfJPA.PagamentoJPA_ItfRep;
import com.example.sistassinaturas.interfAdaptadora.repositorios.entidades.Assinatura;
import com.example.sistassinaturas.interfAdaptadora.repositorios.entidades.Pagamento;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PagamentoRepJPA implements IPagamentoRepositorio {

    private final PagamentoJPA_ItfRep pagamentoJPA;

    public PagamentoRepJPA(PagamentoJPA_ItfRep pagamentoJPA) {
        this.pagamentoJPA = pagamentoJPA;
    }

    @Override
    public PagamentoModel save(PagamentoModel pagamentoModel) {
        Pagamento pagamento = new Pagamento(
            pagamentoModel.getCodigo(),
            new Assinatura(pagamentoModel.getAssinatura().getCodigo(), null, null, null, null),
            pagamentoModel.getValorPago(),
            pagamentoModel.getDataPagamento(),
            pagamentoModel.getPromocao()
        );
        Pagamento savedPagamento = pagamentoJPA.save(pagamento);
        return new PagamentoModel(
            savedPagamento.getCodigo(),
            new AssinaturaModel(savedPagamento.getAssinatura().getCodigo(), null, null, null, null),
            savedPagamento.getValorPago(),
            savedPagamento.getDataPagamento(),
            savedPagamento.getPromocao()
        );
    }

    @Override
    public PagamentoModel findById(Long id) {
        Pagamento pagamento = pagamentoJPA.findById(id).orElse(null);
        if (pagamento == null) {
            return null;
        }
        return new PagamentoModel(
            pagamento.getCodigo(),
            new AssinaturaModel(pagamento.getAssinatura().getCodigo(), null, null, null, null),
            pagamento.getValorPago(),
            pagamento.getDataPagamento(),
            pagamento.getPromocao()
        );
    }

    @Override
    public List<PagamentoModel> findAll() {
        return pagamentoJPA.findAll().stream()
                .map(pagamento -> new PagamentoModel(
                    pagamento.getCodigo(),
                    new AssinaturaModel(pagamento.getAssinatura().getCodigo(), null, null, null, null),
                    pagamento.getValorPago(),
                    pagamento.getDataPagamento(),
                    pagamento.getPromocao()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void update(PagamentoModel pagamentoModel) {
        Pagamento pagamento = new Pagamento(
            pagamentoModel.getCodigo(),
            new Assinatura(pagamentoModel.getAssinatura().getCodigo(), null, null, null, null),
            pagamentoModel.getValorPago(),
            pagamentoModel.getDataPagamento(),
            pagamentoModel.getPromocao()
        );
        pagamentoJPA.save(pagamento);
    }
}
