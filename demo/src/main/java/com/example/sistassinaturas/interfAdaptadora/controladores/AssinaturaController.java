package com.example.sistassinaturas.interfAdaptadora.controladores;

import com.example.sistassinaturas.aplicacao.dtos.AssinaturaDTO;
import com.example.sistassinaturas.dominio.entidades.AssinaturaModel;
import com.example.sistassinaturas.dominio.servicos.ServicoDeAssinatura;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/servcad/assinaturas")
public class AssinaturaController {

    private final ServicoDeAssinatura servicoDeAssinatura;

    public AssinaturaController(ServicoDeAssinatura servicoDeAssinatura) {
        this.servicoDeAssinatura = servicoDeAssinatura;
    }


    @PostMapping("/cadastrar")
    public AssinaturaDTO criarAssinatura(@RequestBody AssinaturaDTO assinaturaDTO) {
        AssinaturaModel assinatura = servicoDeAssinatura.criarAssinatura(assinaturaDTO.getCodigoCliente(), assinaturaDTO.getCodigoAplicativo());
        return new AssinaturaDTO(assinatura.getCodigo(), assinatura.getCliente().getCodigo(), assinatura.getAplicativo().getCodigo(), assinatura.getInicioVigencia(), assinatura.getFimVigencia());
    }

    @GetMapping("/{tipo}")
    public List<AssinaturaDTO> listarAssinaturasPorTipo(@PathVariable String tipo) {
        return servicoDeAssinatura.listarAssinaturasPorTipo(tipo).stream()
                .map(assinatura -> new AssinaturaDTO(assinatura.getCodigo(), assinatura.getCliente().getCodigo(), assinatura.getAplicativo().getCodigo(), assinatura.getInicioVigencia(), assinatura.getFimVigencia()))
                .collect(Collectors.toList());
    }

    @GetMapping("/asscli/{codcli}")
    public List<AssinaturaDTO> listarAssinaturasPorCliente(@PathVariable Long codcli) {
        return servicoDeAssinatura.listarAssinaturasPorCliente(codcli).stream()
                .map(assinatura -> new AssinaturaDTO(assinatura.getCodigo(), assinatura.getCliente().getCodigo(), assinatura.getAplicativo().getCodigo(), assinatura.getInicioVigencia(), assinatura.getFimVigencia()))
                .collect(Collectors.toList());
    }

    @GetMapping("/assapp/{codapp}")
    public List<AssinaturaDTO> listarAssinaturasPorAplicativo(@PathVariable Long codapp) {
        return servicoDeAssinatura.listarAssinaturasPorAplicativo(codapp).stream()
                .map(assinatura -> new AssinaturaDTO(assinatura.getCodigo(), assinatura.getCliente().getCodigo(), assinatura.getAplicativo().getCodigo(), assinatura.getInicioVigencia(), assinatura.getFimVigencia()))
                .collect(Collectors.toList());
    }
}
