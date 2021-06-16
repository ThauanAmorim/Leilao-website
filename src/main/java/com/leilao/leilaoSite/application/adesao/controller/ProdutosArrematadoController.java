package com.leilao.leilaoSite.application.adesao.controller;

import com.leilao.leilaoSite.application.adesao.service.ProdutoLeiloarServiceImpl;
import com.leilao.leilaoSite.domain.leilao.model.ProdutoModel;
import com.leilao.leilaoSite.presentation.produto.dto.ProdutoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produto-arrematado")
public class ProdutosArrematadoController {
    
    @Autowired
    private ProdutoLeiloarServiceImpl produtoServiceImpl;

    @PostMapping
    public ResponseEntity<ProdutoModel> saveProduct(@RequestBody ProdutoDTO  produtoDTO){
        ProdutoModel tempProduct = produtoServiceImpl.salvarProduto(produtoDTO);

        if(tempProduct != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(tempProduct);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
