package com.leilao.leilaoSite.application.adesao.controller;

import com.leilao.leilaoSite.application.adesao.service.LoginServiceImpl;
import com.leilao.leilaoSite.domain.leilao.model.UserModel;
import com.leilao.leilaoSite.presentation.authentication.dto.LoginDTO;
import com.leilao.leilaoSite.presentation.authentication.exception.CredenciaisInvalidasException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
@CrossOrigin
public class LoginController {
    @Autowired
    private LoginServiceImpl loginServiceImpl;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        try {
            UserModel userModel = loginServiceImpl.fazerLogin(loginDTO);
            return ResponseEntity.status(HttpStatus.OK).body(userModel);
        } catch (CredenciaisInvalidasException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }
}
