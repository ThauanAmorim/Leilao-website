package com.leilao.leilaoSite.application.adesao.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import com.leilao.leilaoSite.application.adesao.service.LeilaoService;
import com.leilao.leilaoSite.domain.leilao.model.LeilaoModel;
import com.leilao.leilaoSite.infrastructure.exceptions.DadosObrigatoriosFaltandoException;
import com.leilao.leilaoSite.infrastructure.exceptions.NaoEncontradoException;
import com.leilao.leilaoSite.presentation.Leilao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/leilao")
@CrossOrigin
public class LeilaoController {
    @Autowired
    private LeilaoService leilaoService;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody LeilaoDTO dto, Principal principal) {
        try {
            LeilaoModel leilaoModel = new LeilaoModel(dto);
            leilaoService.salvar(leilaoModel, dto.getListaProdutos(), dto.getCategoria(), principal.getName());
            return ResponseEntity.status(HttpStatus.CREATED).body(null);

        } catch (DadosObrigatoriosFaltandoException | NaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateModel(@RequestBody LeilaoModel model) {
        try {
            leilaoService.salvar(model);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            List<LeilaoModel> listaLeilao = leilaoService.get();    
            return ResponseEntity.status(HttpStatus.OK).body(listaLeilao);
            
        } catch (NaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            leilaoService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (NaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        try {
            LeilaoModel leilao = leilaoService.get(id);
            return ResponseEntity.status(HttpStatus.OK).body(leilao);
        } catch (NaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } 
    }
}
