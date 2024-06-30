package com.example.sistassinaturas.aplicacao.dtos;

import java.time.LocalDate;

public class PagamentoDTO {
    private Long codigo;
    private Long codigoAssinatura;
    private Float valorPago;
    private LocalDate dataPagamento;
    private String promocao;


    public PagamentoDTO(Long codigo, Long codigoAssinatura, Float valorPago, LocalDate dataPagamento, String promocao) {
        this.codigo = codigo;
        this.codigoAssinatura = codigoAssinatura;
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

    public Long getCodigoAssinatura() {
        return this.codigoAssinatura;
    }

    public void setCodigoAssinatura(Long codigoAssinatura) {
        this.codigoAssinatura = codigoAssinatura;
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
            ", codigoAssinatura='" + getCodigoAssinatura() + "'" +
            ", valorPago='" + getValorPago() + "'" +
            ", dataPagamento='" + getDataPagamento() + "'" +
            ", promocao='" + getPromocao() + "'" +
            "}";
    }

}
