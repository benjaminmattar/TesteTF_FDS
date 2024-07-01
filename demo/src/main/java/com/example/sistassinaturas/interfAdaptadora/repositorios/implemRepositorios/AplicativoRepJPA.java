package com.example.sistassinaturas.interfAdaptadora.repositorios.implemRepositorios;

import org.springframework.stereotype.Repository;

import com.example.sistassinaturas.dominio.entidades.AplicativoModel;
import com.example.sistassinaturas.dominio.interfRepositorios.IAplicativoRepositorio;
import com.example.sistassinaturas.interfAdaptadora.repositorios.interfJPA.AplicativoJPA_ItfRep;
import com.example.sistassinaturas.interfAdaptadora.repositorios.entidades.Aplicativo;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class AplicativoRepJPA implements IAplicativoRepositorio {

    private final AplicativoJPA_ItfRep aplicativoJPA;
    private final AtomicLong currentId = new AtomicLong(5); 

    public AplicativoRepJPA(AplicativoJPA_ItfRep aplicativoJPA) {
        this.aplicativoJPA = aplicativoJPA;

        if (aplicativoJPA.count() == 0) {
            aplicativoJPA.save(new Aplicativo(1L, "Netflix", 15.99f));
            aplicativoJPA.save(new Aplicativo(2L, "Spotify", 9.99f));
            aplicativoJPA.save(new Aplicativo(3L, "Amazon Prime", 12.99f));
            aplicativoJPA.save(new Aplicativo(4L, "Hulu", 11.99f));
            aplicativoJPA.save(new Aplicativo(5L, "Disney+", 7.99f));
        } else {
            long maxId = aplicativoJPA.findAll().stream()
                    .mapToLong(Aplicativo::getCodigo)
                    .max()
                    .orElse(5L);
            currentId.set(maxId);
        }
    }

    @Override
    public AplicativoModel save(AplicativoModel aplicativoModel) {
        if (aplicativoModel.getCodigo() == null) {
            aplicativoModel.setCodigo(currentId.incrementAndGet());
        }
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
