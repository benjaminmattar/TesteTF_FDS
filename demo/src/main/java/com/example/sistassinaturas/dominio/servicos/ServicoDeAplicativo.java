package com.example.sistassinaturas.dominio.servicos;

import com.example.sistassinaturas.aplicacao.dtos.AplicativoDTO;
import com.example.sistassinaturas.dominio.entidades.AplicativoModel;
import com.example.sistassinaturas.dominio.interfRepositorios.IAplicativoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoDeAplicativo {

    private final IAplicativoRepositorio aplicativoRepositorio;

    public ServicoDeAplicativo(IAplicativoRepositorio aplicativoRepositorio) {
        this.aplicativoRepositorio = aplicativoRepositorio;
    }

    public List<AplicativoModel> listarTodos() {
        return aplicativoRepositorio.findAll();
    }

    public AplicativoModel atualizarCusto(Long codigo, Float custoMensal) {
        AplicativoModel aplicativo = aplicativoRepositorio.findById(codigo);
        if (aplicativo != null) {
            aplicativo.setCustoMensal(custoMensal);
            aplicativoRepositorio.update(aplicativo);
        }
        return aplicativo;
    }

    public AplicativoModel criarAplicativo(AplicativoDTO aplicativoDTO) {
        AplicativoModel aplicativo = new AplicativoModel(null, aplicativoDTO.getNome(), aplicativoDTO.getCustoMensal());
        return aplicativoRepositorio.save(aplicativo);
    }
}
