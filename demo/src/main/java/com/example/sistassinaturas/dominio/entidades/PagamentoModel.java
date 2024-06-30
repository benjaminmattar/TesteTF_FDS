package com.example.sistassinaturas.dominio.entidades;

import java.time.LocalDate;

public class PagamentoModel {
    private Long codigo;
    private AssinaturaModel assinatura;
    private Float valorPago;
    private LocalDate dataPagamento;
    private String promocao;

    public PagamentoModel(Long codigo, AssinaturaModel assinatura, Float valorPago, LocalDate dataPagamento, String promocao) {
        this.codigo = codigo;
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public Long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public AssinaturaModel getAssinatura() {
        return this.assinatura;
    }

    public void setAssinatura(AssinaturaModel assinatura) {
        this.assinatura = assinatura;
    }

    public Float getValorPago() {
        return this.valorPago;
    }

    public void setValorPago(Float valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDate getDataPagamento() {
        return this.dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getPromocao() {
        return this.promocao;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }

    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", assinatura='" + getAssinatura() + "'" +
            ", valorPago='" + getValorPago() + "'" +
            ", dataPagamento='" + getDataPagamento() + "'" +
            ", promocao='" + getPromocao() + "'" +
            "}";
    }
}
