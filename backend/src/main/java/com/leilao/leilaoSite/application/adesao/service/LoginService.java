package com.leilao.leilaoSite.application.adesao.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.leilao.leilaoSite.domain.leilao.model.UserModel;
import com.leilao.leilaoSite.infrastructure.persistence.repository.user.UserRepository;
import com.leilao.leilaoSite.infrastructure.security.auth.JwtUtils;
import com.leilao.leilaoSite.infrastructure.security.service.UserServiceSecurity;
import com.leilao.leilaoSite.presentation.authentication.dto.LoginDTO;
import com.leilao.leilaoSite.presentation.authentication.exception.CredenciaisInvalidasException;
import com.leilao.leilaoSite.presentation.login.LoginResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserServiceSecurity userServiceSecurity;
    @Autowired
    private UserService userService;
    
    public LoginResponseDTO fazerLogin(LoginDTO loginDTO) throws Exception {
        String username = loginDTO.getUsername();
        String senha = userService.shar256(loginDTO.getSenha());
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, senha));
        } catch (Exception e) {
            throw new Exception("Erro na autenticação ");
        }

        UserDetails loadedUser = userServiceSecurity.loadUserByUsername(username);

        String generatedToken = jwtUtils.generateToken(loadedUser);

        LoginResponseDTO responseDTO = new LoginResponseDTO();
        responseDTO.setResponse(generatedToken);
        return responseDTO;
    }
}
