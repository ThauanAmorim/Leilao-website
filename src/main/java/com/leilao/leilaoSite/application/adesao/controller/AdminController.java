package com.leilao.leilaoSite.application.adesao.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import com.leilao.leilaoSite.application.adesao.service.AdminServiceImpl;
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
    private AdminServiceImpl adminServiceImpl;

    @GetMapping
    public List<UserModel> pegarTodosOsAdmins() {
        return adminServiceImpl.getAllAdmins();
    }

    @GetMapping("/{username}")
    public UserModel pegarAdminPeloId(@PathVariable String username) {
        return adminServiceImpl.getAdminByUsername(username);
    }

    @GetMapping("/salvar/{username}")
    public UserModel salvarAdmin(@PathVariable String username) {
        return adminServiceImpl.saveAdminByUsername(username);
    }

    @PostMapping("/salvar")
    public UserModel salvarAdmin(@RequestBody UserModel userModel) {
        return adminServiceImpl.saveAdmin(userModel);
    }
}
