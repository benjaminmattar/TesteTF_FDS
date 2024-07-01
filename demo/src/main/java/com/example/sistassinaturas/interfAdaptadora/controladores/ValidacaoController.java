package com.example.sistassinaturas.interfAdaptadora.controladores;

import com.example.sistassinaturas.dominio.servicos.ServicoDeAssinatura;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assinvalida")
public class ValidacaoController {

    private final ServicoDeAssinatura servicoDeAssinatura;

    public ValidacaoController(ServicoDeAssinatura servicoDeAssinatura) {
        this.servicoDeAssinatura = servicoDeAssinatura;
    }
    
    @GetMapping("/{codass}")
    public boolean assinaturaValida(@PathVariable Long codass) {
        return servicoDeAssinatura.assinaturaValida(codass);
    }
}