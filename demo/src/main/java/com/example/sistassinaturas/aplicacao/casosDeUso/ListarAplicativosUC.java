package com.example.sistassinaturas.aplicacao.casosDeUso;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.sistassinaturas.aplicacao.dtos.AplicativoDTO;
import com.example.sistassinaturas.dominio.entidades.AplicativoModel;
import com.example.sistassinaturas.dominio.servicos.ServicoDeAplicativo;

@Component
public class ListarAplicativosUC {
    private final ServicoDeAplicativo aplicativoServico;

    public ListarAplicativosUC(ServicoDeAplicativo aplicativoServico) {
        this.aplicativoServico = aplicativoServico;
    }

    public List<AplicativoDTO> executar() {
        List<AplicativoModel> aplicativos = aplicativoServico.listarTodos();
        return aplicativos.stream()
            .map(app -> new AplicativoDTO(app.getCodigo(), app.getNome(), app.getCustoMensal()))
            .collect(Collectors.toList());
    }
}
