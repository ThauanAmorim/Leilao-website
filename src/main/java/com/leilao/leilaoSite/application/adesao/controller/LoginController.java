package com.leilao.leilaoSite.application.adesao.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.leilao.leilaoSite.application.adesao.service.LoginServiceImpl;
import com.leilao.leilaoSite.domain.adesao.model.UserModel;
import com.leilao.leilaoSite.presentation.authentication.dto.LoginDTO;
import com.leilao.leilaoSite.presentation.authentication.exception.CredenciaisInvalidasException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    private LoginServiceImpl loginServiceImpl;

    @PostMapping
    public UserModel login(@RequestBody LoginDTO loginDTO) {
        try {
            return loginServiceImpl.fazerLogin(loginDTO);
        } catch (CredenciaisInvalidasException e) {
            throw e;
        }
    }
}
