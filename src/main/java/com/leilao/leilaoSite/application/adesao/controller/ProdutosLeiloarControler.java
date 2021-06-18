package com.leilao.leilaoSite.application.adesao.controller;

import com.leilao.leilaoSite.application.adesao.service.ProdutoLeiloarServiceImpl;
import com.leilao.leilaoSite.domain.leilao.model.ProdutoModel;
import com.leilao.leilaoSite.presentation.produto.dto.ProdutoLeiloarDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos-leiloar")
public class ProdutosLeiloarControler {
    
    @Autowired
    private ProdutoLeiloarServiceImpl produtoLeiloarServiceImpl;

    @PostMapping
    public ResponseEntity<ProdutoModel> salvarProdutoLeiloar(@RequestBody ProdutoLeiloarDTO produto){
        ProdutoModel tempProduto = produtoLeiloarServiceImpl.salvarProduto(produto);

        if(tempProduto != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(tempProduto);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @PatchMapping
    public ProdutoModel update(@RequestBody ProdutoLeiloarDTO produtoDTO){
        return produtoLeiloarServiceImpl.update(produtoDTO);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody ProdutoLeiloarDTO produtoLeiloarDTO){
        String msg = produtoLeiloarServiceImpl.delete(produtoLeiloarDTO.getId());

        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }
}
