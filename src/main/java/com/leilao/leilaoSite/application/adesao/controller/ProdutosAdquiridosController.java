package com.leilao.leilaoSite.application.adesao.controller;

import com.leilao.leilaoSite.domain.leilao.model.ModeloProduto;
import com.leilao.leilaoSite.presentation.produto.dto.ProdutoDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produto-adquirido")
public class ProdutosAdquiridosController {
    
    @PostMapping
    public ModeloProduto salvarProdutoAdquirido(@RequestBody ProdutoDTO produtoDTO) {
        return null;
    }
}
