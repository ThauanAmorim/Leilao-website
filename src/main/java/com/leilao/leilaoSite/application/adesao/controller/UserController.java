package com.leilao.leilaoSite.application.adesao.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import com.leilao.leilaoSite.application.adesao.service.UserServiceImpl;
import com.leilao.leilaoSite.domain.adesao.model.UserModel;
import com.leilao.leilaoSite.infrastructure.persistence.repository.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping
    public UserModel salvarUser(@RequestBody UserModel user) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        user.setBirthday(new Date(System.currentTimeMillis()));

        userServiceImpl.criptografarSenha(user);
        return userServiceImpl.salvarUser(user);
    }

    @PostMapping("/{username}")
    public UserModel getUserByUsername(@RequestBody String username) {
        System.out.println(username);
        return userServiceImpl.getUserByUsername(username);
    }

    @GetMapping
    public List<UserModel> getTodosUsers() {
        return userServiceImpl.getAllUsers();
    }
}
