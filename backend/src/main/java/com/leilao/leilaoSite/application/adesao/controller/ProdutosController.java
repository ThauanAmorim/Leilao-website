package com.leilao.leilaoSite.application.adesao.controller;

import java.security.Principal;

import com.leilao.leilaoSite.application.adesao.service.ProdutoLeiloarService;
import com.leilao.leilaoSite.domain.leilao.model.ProdutoModel;
import com.leilao.leilaoSite.presentation.produto.dto.ProdutoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;

@RestController
@RequestMapping("/api/produtos-leiloar")
@CrossOrigin
public class ProdutosController {
    
    @Autowired
    private ProdutoLeiloarService produtoLeiloarServiceImpl;

    @PostMapping
    public ResponseEntity<ProdutoModel> salvarProdutoLeiloar(@RequestBody ProdutoDTO produto, Principal principal){
        produto.setUsername(principal.getName());
        ProdutoModel tempProduto = produtoLeiloarServiceImpl.salvarProduto(produto);

        if(tempProduto != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(tempProduto);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @PatchMapping
    public ProdutoModel update(@RequestBody ProdutoDTO produtoDTO){
        return produtoLeiloarServiceImpl.update(produtoDTO);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody ProdutoDTO produtoLeiloarDTO){
        String msg = produtoLeiloarServiceImpl.delete(produtoLeiloarDTO.getId());

        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }

    @GetMapping
    public ResponseEntity<?> getByUsername(Principal principal) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(produtoLeiloarServiceImpl.findByUser(principal.getName()));
            
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
