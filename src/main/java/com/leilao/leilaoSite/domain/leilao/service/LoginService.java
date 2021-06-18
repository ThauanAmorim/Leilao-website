package com.leilao.leilaoSite.domain.leilao.service;

import com.leilao.leilaoSite.domain.leilao.model.UserModel;
import com.leilao.leilaoSite.presentation.authentication.dto.LoginDTO;

public interface LoginService {
    public UserModel fazerLogin(LoginDTO loginDTO);
}
