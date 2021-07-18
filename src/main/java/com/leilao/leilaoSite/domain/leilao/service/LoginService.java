package com.leilao.leilaoSite.domain.leilao.service;

import com.leilao.leilaoSite.domain.leilao.model.UserModel;
import com.leilao.leilaoSite.presentation.authentication.dto.LoginDTO;
import com.leilao.leilaoSite.presentation.login.LoginResponseDTO;

public interface LoginService {
    public LoginResponseDTO fazerLogin(LoginDTO loginDTO) throws Exception;
}
