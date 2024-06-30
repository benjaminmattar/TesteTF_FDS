package com.example.sistassinaturas.interfAdaptadora.controladores;

import com.example.sistassinaturas.aplicacao.dtos.AplicativoDTO;
import com.example.sistassinaturas.dominio.entidades.AplicativoModel;
import com.example.sistassinaturas.dominio.servicos.ServicoDeAplicativo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/servcad/aplicativos")
public class AplicativoController {

    private final ServicoDeAplicativo servicoDeAplicativo;

    public AplicativoController(ServicoDeAplicativo servicoDeAplicativo) {
        this.servicoDeAplicativo = servicoDeAplicativo;
    }

    @GetMapping
    public List<AplicativoDTO> listarAplicativos() {
        return servicoDeAplicativo.listarTodos().stream()
                .map(aplicativo -> new AplicativoDTO(aplicativo.getCodigo(), aplicativo.getNome(), aplicativo.getCustoMensal()))
                .collect(Collectors.toList());
    }

   

    @PostMapping("/atualizacusto/{idAplicativo}")
    public AplicativoDTO atualizarCusto(@PathVariable Long idAplicativo, @RequestBody AplicativoDTO aplicativoDTO) {
        AplicativoModel atualizado = servicoDeAplicativo.atualizarCusto(idAplicativo, aplicativoDTO.getCustoMensal());
        return new AplicativoDTO(atualizado.getCodigo(), atualizado.getNome(), atualizado.getCustoMensal());
    }




    @PostMapping("/criar")
    public AplicativoDTO criarAplicativo(@RequestBody AplicativoDTO aplicativoDTO) {
        AplicativoModel criado = servicoDeAplicativo.criarAplicativo(aplicativoDTO);
        return new AplicativoDTO(criado.getCodigo(), criado.getNome(), criado.getCustoMensal());
    }
}
