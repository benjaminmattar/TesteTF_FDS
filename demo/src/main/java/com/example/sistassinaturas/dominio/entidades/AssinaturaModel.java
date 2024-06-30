package com.example.sistassinaturas.dominio.entidades;

import java.time.LocalDate;

public class AssinaturaModel {
    private Long codigo;
    private AplicativoModel aplicativo;
    private ClienteModel cliente;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;


    public AssinaturaModel() {
    }
    
    public AssinaturaModel(Long codigo, AplicativoModel aplicativo, ClienteModel cliente, LocalDate inicioVigencia, LocalDate fimVigencia) {
        this.codigo = codigo;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }


    public Long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public AplicativoModel getAplicativo() {
        return this.aplicativo;
    }

    public void setAplicativo(AplicativoModel aplicativo) {
        this.aplicativo = aplicativo;
    }

    public ClienteModel getCliente() {
        return this.cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
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
            ", aplicativo='" + getAplicativo() + "'" +
            ", cliente='" + getCliente() + "'" +
            ", inicioVigencia='" + getInicioVigencia() + "'" +
            ", fimVigencia='" + getFimVigencia() + "'" +
            "}";
    }

}
