package com.example.sistassinaturas.interfAdaptadora.repositorios.implemRepositorios;

import org.springframework.stereotype.Repository;

import com.example.sistassinaturas.dominio.entidades.AplicativoModel;
import com.example.sistassinaturas.dominio.interfRepositorios.IAplicativoRepositorio;
import com.example.sistassinaturas.interfAdaptadora.repositorios.interfJPA.AplicativoJPA_ItfRep;
import com.example.sistassinaturas.interfAdaptadora.repositorios.entidades.Aplicativo;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AplicativoRepJPA implements IAplicativoRepositorio {

    private final AplicativoJPA_ItfRep aplicativoJPA;

    public AplicativoRepJPA(AplicativoJPA_ItfRep aplicativoJPA) {
        this.aplicativoJPA = aplicativoJPA;
    }

    @Override
    public AplicativoModel save(AplicativoModel aplicativoModel) {
        Aplicativo aplicativo = new Aplicativo(aplicativoModel.getCodigo(), aplicativoModel.getNome(), aplicativoModel.getCustoMensal());
        Aplicativo savedAplicativo = aplicativoJPA.save(aplicativo);
        return new AplicativoModel(savedAplicativo.getCodigo(), savedAplicativo.getNome(), savedAplicativo.getCustoMensal());
    }

    @Override
    public AplicativoModel findById(Long id) {
        Aplicativo aplicativo = aplicativoJPA.findById(id).orElse(null);
        if (aplicativo == null) {
            return null;
        }
        return new AplicativoModel(aplicativo.getCodigo(), aplicativo.getNome(), aplicativo.getCustoMensal());
    }

    @Override
    public List<AplicativoModel> findAll() {
        return aplicativoJPA.findAll().stream()
                .map(aplicativo -> new AplicativoModel(aplicativo.getCodigo(), aplicativo.getNome(), aplicativo.getCustoMensal()))
                .collect(Collectors.toList());
    }

    @Override
    public void update(AplicativoModel aplicativoModel) {
        Aplicativo aplicativo = new Aplicativo(aplicativoModel.getCodigo(), aplicativoModel.getNome(), aplicativoModel.getCustoMensal());
        aplicativoJPA.save(aplicativo);
    }
}
