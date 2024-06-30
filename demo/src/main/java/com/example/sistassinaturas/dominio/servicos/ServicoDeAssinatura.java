package com.example.sistassinaturas.dominio.servicos;

import com.example.sistassinaturas.dominio.entidades.AplicativoModel;
import com.example.sistassinaturas.dominio.entidades.AssinaturaModel;
import com.example.sistassinaturas.dominio.entidades.ClienteModel;
import com.example.sistassinaturas.dominio.interfRepositorios.IAplicativoRepositorio;
import com.example.sistassinaturas.dominio.interfRepositorios.IAssinaturaRepositorio;
import com.example.sistassinaturas.dominio.interfRepositorios.IClienteRepositorio;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicoDeAssinatura {
    private final IAssinaturaRepositorio assinaturaRepositorio;
    private final IClienteRepositorio clienteRepositorio;
    private final IAplicativoRepositorio aplicativoRepositorio;

    public ServicoDeAssinatura(IAssinaturaRepositorio assinaturaRepositorio, IClienteRepositorio clienteRepositorio, IAplicativoRepositorio aplicativoRepositorio) {
        this.assinaturaRepositorio = assinaturaRepositorio;
        this.clienteRepositorio = clienteRepositorio;
        this.aplicativoRepositorio = aplicativoRepositorio;
    }

    public AssinaturaModel criarAssinatura(Long codigoCliente, Long codigoAplicativo) {
        ClienteModel cliente = clienteRepositorio.findById(codigoCliente);
        AplicativoModel aplicativo = aplicativoRepositorio.findById(codigoAplicativo);
        
        AssinaturaModel assinatura = new AssinaturaModel();
        assinatura.setCliente(cliente);
        assinatura.setAplicativo(aplicativo);
        assinatura.setInicioVigencia(LocalDate.now());
        assinatura.setFimVigencia(LocalDate.now().plusDays(7)); // 7 dias grÃ¡tis

        return assinaturaRepositorio.save(assinatura);
    }

    public List<AssinaturaModel> listarAssinaturasPorTipo(String tipo) {
        if (tipo.equals("ATIVAS")) {
            return assinaturaRepositorio.findAll().stream().filter(assinatura -> assinatura.getFimVigencia().isAfter(LocalDate.now())).toList();
        } else if (tipo.equals("CANCELADAS")) {
            return assinaturaRepositorio.findAll().stream().filter(assinatura -> assinatura.getFimVigencia().isBefore(LocalDate.now())).toList();
        } else {
            return assinaturaRepositorio.findAll();
        }
    }

    public List<AssinaturaModel> listarAssinaturasPorCliente(Long codigoCliente) {
        return assinaturaRepositorio.findByCliente(codigoCliente);
    }

    public List<AssinaturaModel> listarAssinaturasPorAplicativo(Long codigoAplicativo) {
        return assinaturaRepositorio.findByAplicativo(codigoAplicativo);
    }

    public boolean assinaturaValida(Long codass) {
        AssinaturaModel assinatura = assinaturaRepositorio.findById(codass);
        return assinatura != null && assinatura.getFimVigencia().isAfter(LocalDate.now());
    }
}