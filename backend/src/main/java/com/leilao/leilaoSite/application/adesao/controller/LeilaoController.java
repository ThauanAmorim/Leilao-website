package com.leilao.leilaoSite.application.adesao.controller;

import com.leilao.leilaoSite.application.adesao.service.LeilaoService;
import com.leilao.leilaoSite.presentation.Leilao.LeilaoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/leilao")
public class LeilaoController {
    @Autowired
    private LeilaoService leilaoService;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody LeilaoDTO dto) {
        leilaoService.salvar(leilaoModel, dto.getListaProdutos());
    }
}
