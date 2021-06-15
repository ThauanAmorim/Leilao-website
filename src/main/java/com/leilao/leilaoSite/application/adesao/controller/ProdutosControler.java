package com.leilao.leilaoSite.application.adesao.controller;

import com.leilao.leilaoSite.application.adesao.service.ProdutoServiceImpl;
import com.leilao.leilaoSite.domain.adesao.service.ProductService;
import com.leilao.leilaoSite.domain.leilao.model.ModeloProduto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("/api/products")
public class ProdutosControler {
    
    @Autowired
    private ProdutoServiceImpl produtoServiceImpl;

    @PostMapping
    public ResponseEntity<ModeloProduto> saveProduct(@RequestBody ModeloProduto  product){
        ModeloProduto tempProduct = produtoServiceImpl.saveProduct(product);

        if(tempProduct != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(tempProduct);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
