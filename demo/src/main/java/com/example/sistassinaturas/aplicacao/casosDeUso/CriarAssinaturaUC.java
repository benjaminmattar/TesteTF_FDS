package com.example.sistassinaturas.aplicacao.casosDeUso;

import org.springframework.stereotype.Component;

import com.example.sistassinaturas.aplicacao.dtos.AssinaturaDTO;
import com.example.sistassinaturas.dominio.entidades.AssinaturaModel;
import com.example.sistassinaturas.dominio.servicos.ServicoDeAssinatura;

@Component
public class CriarAssinaturaUC {
    private final ServicoDeAssinatura assinaturaServico;

    public CriarAssinaturaUC(ServicoDeAssinatura assinaturaServico) {
        this.assinaturaServico = assinaturaServico;
    }

    public AssinaturaDTO executar(Long codigoCliente, Long codigoAplicativo) {
        AssinaturaModel assinaturaModel = assinaturaServico.criarAssinatura(codigoCliente, codigoAplicativo);
        return new AssinaturaDTO(
            assinaturaModel.getCodigo(),
            assinaturaModel.getCliente().getCodigo(),
            assinaturaModel.getAplicativo().getCodigo(),
            assinaturaModel.getInicioVigencia(),
            assinaturaModel.getFimVigencia()
        );
    }
}
