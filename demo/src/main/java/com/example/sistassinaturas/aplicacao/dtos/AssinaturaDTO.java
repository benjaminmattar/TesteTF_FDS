package com.example.sistassinaturas.aplicacao.dtos;

import java.time.LocalDate;

public class AssinaturaDTO {
    private Long codigo;
    private Long codigoCliente;
    private Long codigoAplicativo;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;


    public AssinaturaDTO(Long codigo, Long codigoCliente, Long codigoAplicativo, LocalDate inicioVigencia, LocalDate fimVigencia) {
        this.codigo = codigo;
        this.codigoCliente = codigoCliente;
        this.codigoAplicativo = codigoAplicativo;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }

    public Long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigoCliente() {
        return this.codigoCliente;
    }

    public void setCodigoCliente(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Long getCodigoAplicativo() {
        return this.codigoAplicativo;
    }

    public void setCodigoAplicativo(Long codigoAplicativo) {
        this.codigoAplicativo = codigoAplicativo;
    }

    public LocalDate getInicioVigencia() {
        return this.inicioVigencia;
    }

    public void setInicioVigencia(LocalDate inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public LocalDate getFimVigencia() {
        return this.fimVigencia;
    }

    public void setFimVigencia(LocalDate fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", codigoCliente='" + getCodigoCliente() + "'" +
            ", codigoAplicativo='" + getCodigoAplicativo() + "'" +
            ", inicioVigencia='" + getInicioVigencia() + "'" +
            ", fimVigencia='" + getFimVigencia() + "'" +
            "}";
    }
}
