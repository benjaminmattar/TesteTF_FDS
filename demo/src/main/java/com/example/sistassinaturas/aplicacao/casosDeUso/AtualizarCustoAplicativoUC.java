package com.example.sistassinaturas.aplicacao.casosDeUso;

import org.springframework.stereotype.Component;

import com.example.sistassinaturas.aplicacao.dtos.AplicativoDTO;
import com.example.sistassinaturas.dominio.entidades.AplicativoModel;
import com.example.sistassinaturas.dominio.servicos.ServicoDeAplicativo;

@Component
public class AtualizarCustoAplicativoUC {
    private final ServicoDeAplicativo aplicativoServico;

    public AtualizarCustoAplicativoUC(ServicoDeAplicativo aplicativoServico) {
        this.aplicativoServico = aplicativoServico;
    }

    public AplicativoDTO executar(Long codigo, Float custoMensal) {
        AplicativoModel aplicativoModel = aplicativoServico.atualizarCusto(codigo, custoMensal);
        return new AplicativoDTO(
            aplicativoModel.getCodigo(),
            aplicativoModel.getNome(),
            aplicativoModel.getCustoMensal()
        );
    }
}
