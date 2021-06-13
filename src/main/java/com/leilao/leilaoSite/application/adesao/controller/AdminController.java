package com.leilao.leilaoSite.application.adesao.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import com.leilao.leilaoSite.domain.adesao.model.ModeloAdmin;
import com.leilao.leilaoSite.domain.adesao.model.UserModel;
import com.leilao.leilaoSite.infrastructure.persistence.repository.admin.AdminRepository;
import com.leilao.leilaoSite.infrastructure.persistence.repository.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<ModeloAdmin> pegarTodosOsAdmins() {
        return adminRepository.findAll();
    }

    @PostMapping("/{id}")
    public ModeloAdmin salvarAdmin(@PathVariable Long id) {
        UserModel userModel = userRepository.getById(id);

        if(userModel != null) {
            ModeloAdmin adminModel = new ModeloAdmin();
            adminModel.setId(id);
            return adminRepository.save(adminModel);
        }
        return null;
    }

    @PostMapping
    public ModeloAdmin salvarAdmin(@RequestBody ModeloAdmin modeloAdmin) {
        if(modeloAdmin != null) {
            adminRepository.save(modeloAdmin);
            return modeloAdmin;
        }
        return null;
    }
}
