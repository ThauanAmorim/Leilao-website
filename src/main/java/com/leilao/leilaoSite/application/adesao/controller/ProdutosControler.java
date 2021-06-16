package com.leilao.leilaoSite.application.adesao.controller;

import com.leilao.leilaoSite.application.adesao.service.ProdutoServiceImpl;
import com.leilao.leilaoSite.domain.leilao.model.ProdutoModel;
import com.leilao.leilaoSite.presentation.produto.dto.ProdutoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProdutosControler {
    
    @Autowired
    private ProdutoServiceImpl produtoServiceImpl;

    @PostMapping
    public ResponseEntity<ProdutoModel> salvarProduto(@RequestBody ProdutoDTO produto){
        ProdutoModel tempProduto = produtoServiceImpl.salvarProduto(produto);

        if(tempProduto != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(tempProduto);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
