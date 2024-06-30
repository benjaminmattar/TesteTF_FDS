package com.example.sistassinaturas.interfAdaptadora.controladores;

import com.example.sistassinaturas.aplicacao.dtos.PagamentoDTO;
import com.example.sistassinaturas.dominio.entidades.AssinaturaModel;
import com.example.sistassinaturas.dominio.entidades.PagamentoModel;
import com.example.sistassinaturas.dominio.servicos.ServicoDePagamento;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registrarpagamento")
public class PagamentoController {

    private final ServicoDePagamento servicoDePagamento;

    public PagamentoController(ServicoDePagamento servicoDePagamento) {
        this.servicoDePagamento = servicoDePagamento;
    }

    @PostMapping
    public PagamentoDTO registrarPagamento(@RequestBody PagamentoDTO pagamentoDTO) {
        PagamentoModel pagamento = new PagamentoModel(
                pagamentoDTO.getCodigo(),
                new AssinaturaModel(pagamentoDTO.getCodigoAssinatura(), null, null, null, null),
                pagamentoDTO.getValorPago(),
                pagamentoDTO.getDataPagamento(),
                pagamentoDTO.getPromocao()
        );
        PagamentoModel registrado = servicoDePagamento.registrarPagamento(pagamento);
        return new PagamentoDTO(registrado.getCodigo(), registrado.getAssinatura().getCodigo(), registrado.getValorPago(), registrado.getDataPagamento(), registrado.getPromocao());
    }
}
