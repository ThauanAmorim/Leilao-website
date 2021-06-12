package com.leilao.leilaoSite.application.adesao.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.leilao.leilaoSite.domain.adesao.model.UserModel;
import com.leilao.leilaoSite.domain.adesao.service.LoginService;
import com.leilao.leilaoSite.infrastructure.persistence.repository.user.UserRepository;
import com.leilao.leilaoSite.presentation.authentication.dto.LoginDTO;
import com.leilao.leilaoSite.presentation.authentication.exception.CredenciaisInvalidasException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Override
    public UserModel fazerLogin(LoginDTO loginDTO) {
        UserModel user = userRepository.findByUsername(loginDTO.getUsername());

        boolean status = false;
        if(user != null) {
            try {
                status = userServiceImpl.verificarSenha(loginDTO.getSenha(), user.getPassword());
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
                throw new CredenciaisInvalidasException();
            }
        }

        if(status) {
            return user;
        }
        throw new CredenciaisInvalidasException();
    }
}
