package com.leilao.leilaoSite.application.adesao.controller;

import java.util.List;

import com.leilao.leilaoSite.application.adesao.service.CategoriaService;
import com.leilao.leilaoSite.domain.leilao.model.CategoriaModel;
import com.leilao.leilaoSite.domain.leilao.model.UserModel;
import com.leilao.leilaoSite.infrastructure.exceptions.DadosObrigatoriosFaltandoException;
import com.leilao.leilaoSite.infrastructure.exceptions.NaoEncontradoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/categoria")
@CrossOrigin
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<?> salvarCategoria(@RequestBody CategoriaModel categoria){
        try {
            categoriaService.salvar(categoria);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);

        } catch (DadosObrigatoriosFaltandoException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        }
    }

    @GetMapping
    public ResponseEntity<?> recuperarTodasCategorias() {
        try {
            List<CategoriaModel> lista = categoriaService.recuperaTodasCategorias();
            return ResponseEntity.status(HttpStatus.OK).body(lista);
            
        } catch (NaoEncontradoException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> recuperarCategoriaPeloID(@PathVariable("id") Long id){
        try {
            CategoriaModel categoria = categoriaService.recuperarPeloId(id);
            return ResponseEntity.status(HttpStatus.OK).body(categoria);
            
        } catch (NaoEncontradoException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            
        }
    }
}
