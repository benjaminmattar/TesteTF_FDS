package com.example.sistassinaturas.interfAdaptadora.controladores;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String welcomeMessage() {
        return "Bem vindo ao sistema de assinaturas e aplicativos";
    }
}
