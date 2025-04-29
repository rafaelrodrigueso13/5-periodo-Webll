package com.example.projeto.controller;

import com.example.projeto.service.RestController;
import com.example.projeto.service.RequestMapping;
import com.example.projeto.service.GetMapping;
import com.example.projeto.service.MensagemService;


@RestController
@RequestMapping("/api")
public class MensagemController {
    private final MensagemService mensagemService;

    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }

    @GetMapping("/mensagem")
    public String obterMensagem() {
        return mensagemService.obterMensagem();
    }
}