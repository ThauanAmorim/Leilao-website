package com.leilao.leilaoSite.application.adesao.controller;

import java.util.List;

import com.leilao.leilaoSite.application.adesao.service.CategoriaService;
import com.leilao.leilaoSite.domain.leilao.model.CategoriaModel;
import com.leilao.leilaoSite.domain.leilao.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaServiceImpl;

    @PostMapping
    public void salvarCategoria(@RequestBody CategoriaModel categoria){
        categoriaServiceImpl.salvar(categoria);
    }

    @GetMapping
    public ResponseEntity<?> recuperarTodasCategorias(){
        return categoriaServiceImpl.recuperaTodasCategorias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> recuperarCategoriaPeloID(@PathVariable("id") Long id){
        return categoriaServiceImpl.recuperarPeloId(id);
    }
}
