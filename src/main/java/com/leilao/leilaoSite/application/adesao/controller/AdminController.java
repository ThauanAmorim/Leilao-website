package com.leilao.leilaoSite.application.adesao.controller;

import java.util.List;

import com.leilao.leilaoSite.domain.adesao.model.ModeloAdmin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    

    @GetMapping
    public List<ModeloAdmin> pegarTodosOsAdmins() {
        return null;
    }
}
