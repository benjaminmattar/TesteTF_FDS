package com.example.sistassinaturas.dominio.entidades;

public class AplicativoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;      
    private String nome;
    private Float custoMensal;      

    public AplicativoModel(Long codigo, String nome, Float custoMensal) {
        this.codigo = codigo;
        this.nome = nome;
        this.custoMensal = custoMensal;
    }


    public Long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getCustoMensal() {
        return this.custoMensal;
    }

    public void setCustoMensal(Float custoMensal) {
        this.custoMensal = custoMensal;
    }

    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", nome='" + getNome() + "'" +
            ", custoMensal='" + getCustoMensal() + "'" +
            "}";
    }
}
