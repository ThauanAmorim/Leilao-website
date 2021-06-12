package com.leilao.leilaoSite.domain.adesao.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.leilao.leilaoSite.domain.adesao.model.UserModel;
import com.leilao.leilaoSite.presentation.authentication.dto.LoginDTO;

public interface LoginService {
    public UserModel fazerLogin(LoginDTO loginDTO) throws NoSuchAlgorithmException, UnsupportedEncodingException;
}
