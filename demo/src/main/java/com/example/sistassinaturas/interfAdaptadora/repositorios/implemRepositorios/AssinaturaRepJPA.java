package com.example.sistassinaturas.interfAdaptadora.repositorios.implemRepositorios;

import org.springframework.stereotype.Repository;

import com.example.sistassinaturas.dominio.entidades.AplicativoModel;
import com.example.sistassinaturas.dominio.entidades.AssinaturaModel;
import com.example.sistassinaturas.dominio.entidades.ClienteModel;
import com.example.sistassinaturas.dominio.interfRepositorios.IAssinaturaRepositorio;
import com.example.sistassinaturas.interfAdaptadora.repositorios.interfJPA.AssinaturaJPA_ItfRep;
import com.example.sistassinaturas.interfAdaptadora.repositorios.entidades.Aplicativo;
import com.example.sistassinaturas.interfAdaptadora.repositorios.entidades.Assinatura;
import com.example.sistassinaturas.interfAdaptadora.repositorios.entidades.Cliente;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class AssinaturaRepJPA implements IAssinaturaRepositorio {

    private final AssinaturaJPA_ItfRep assinaturaJPA;
    private final AtomicLong currentId;

    public AssinaturaRepJPA(AssinaturaJPA_ItfRep assinaturaJPA) {
        this.assinaturaJPA = assinaturaJPA;

        long maxId = assinaturaJPA.findAll().stream()
                .mapToLong(Assinatura::getCodigo)
                .max()
                .orElse(0L);
        currentId = new AtomicLong(maxId);
    }

    @Override
    public AssinaturaModel save(AssinaturaModel assinaturaModel) {
        if (assinaturaModel.getCodigo() == null) {
            assinaturaModel.setCodigo(currentId.incrementAndGet());
        }
        Assinatura assinatura = new Assinatura(
            assinaturaModel.getCodigo(),
            new Aplicativo(assinaturaModel.getAplicativo().getCodigo(), assinaturaModel.getAplicativo().getNome(), assinaturaModel.getAplicativo().getCustoMensal()),
            new Cliente(assinaturaModel.getCliente().getCodigo(), assinaturaModel.getCliente().getNome(), assinaturaModel.getCliente().getEmail()),
            assinaturaModel.getInicioVigencia(),
            assinaturaModel.getFimVigencia()
        );
        Assinatura savedAssinatura = assinaturaJPA.save(assinatura);
        return new AssinaturaModel(
            savedAssinatura.getCodigo(),
            new AplicativoModel(savedAssinatura.getAplicativo().getCodigo(), savedAssinatura.getAplicativo().getNome(), savedAssinatura.getAplicativo().getCustoMensal()),
            new ClienteModel(savedAssinatura.getCliente().getCodigo(), savedAssinatura.getCliente().getNome(), savedAssinatura.getCliente().getEmail()),
            savedAssinatura.getInicioVigencia(),
            savedAssinatura.getFimVigencia()
        );
    }

    @Override
    public AssinaturaModel findById(Long id) {
        Assinatura assinatura = assinaturaJPA.findById(id).orElse(null);
        if (assinatura == null) {
            return null;
        }
        return new AssinaturaModel(
            assinatura.getCodigo(),
            new AplicativoModel(assinatura.getAplicativo().getCodigo(), assinatura.getAplicativo().getNome(), assinatura.getAplicativo().getCustoMensal()),
            new ClienteModel(assinatura.getCliente().getCodigo(), assinatura.getCliente().getNome(), assinatura.getCliente().getEmail()),
            assinatura.getInicioVigencia(),
            assinatura.getFimVigencia()
        );
    }

    @Override
    public List<AssinaturaModel> findAll() {
        return assinaturaJPA.findAll().stream()
                .map(assinatura -> new AssinaturaModel(
                    assinatura.getCodigo(),
                    new AplicativoModel(assinatura.getAplicativo().getCodigo(), assinatura.getAplicativo().getNome(), assinatura.getAplicativo().getCustoMensal()),
                    new ClienteModel(assinatura.getCliente().getCodigo(), assinatura.getCliente().getNome(), assinatura.getCliente().getEmail()),
                    assinatura.getInicioVigencia(),
                    assinatura.getFimVigencia()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void update(AssinaturaModel assinaturaModel) {
        Assinatura assinatura = new Assinatura(
            assinaturaModel.getCodigo(),
            new Aplicativo(assinaturaModel.getAplicativo().getCodigo(), assinaturaModel.getAplicativo().getNome(), assinaturaModel.getAplicativo().getCustoMensal()),
            new Cliente(assinaturaModel.getCliente().getCodigo(), assinaturaModel.getCliente().getNome(), assinaturaModel.getCliente().getEmail()),
            assinaturaModel.getInicioVigencia(),
            assinaturaModel.getFimVigencia()
        );
        assinaturaJPA.save(assinatura);
    }

    @Override
    public List<AssinaturaModel> findByCliente(Long codigoCliente) {
        return assinaturaJPA.findByClienteCodigo(codigoCliente).stream()
                .map(assinatura -> new AssinaturaModel(
                    assinatura.getCodigo(),
                    new AplicativoModel(assinatura.getAplicativo().getCodigo(), assinatura.getAplicativo().getNome(), assinatura.getAplicativo().getCustoMensal()),
                    new ClienteModel(assinatura.getCliente().getCodigo(), assinatura.getCliente().getNome(), assinatura.getCliente().getEmail()),
                    assinatura.getInicioVigencia(),
                    assinatura.getFimVigencia()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<AssinaturaModel> findByAplicativo(Long codigoAplicativo) {
        return assinaturaJPA.findByAplicativoCodigo(codigoAplicativo).stream()
                .map(assinatura -> new AssinaturaModel(
                    assinatura.getCodigo(),
                    new AplicativoModel(assinatura.getAplicativo().getCodigo(), assinatura.getAplicativo().getNome(), assinatura.getAplicativo().getCustoMensal()),
                    new ClienteModel(assinatura.getCliente().getCodigo(), assinatura.getCliente().getNome(), assinatura.getCliente().getEmail()),
                    assinatura.getInicioVigencia(),
                    assinatura.getFimVigencia()
                ))
                .collect(Collectors.toList());
    }
}
