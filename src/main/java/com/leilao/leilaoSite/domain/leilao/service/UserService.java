package com.leilao.leilaoSite.domain.leilao.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.leilao.leilaoSite.domain.leilao.model.UserModel;
import com.leilao.leilaoSite.presentation.authentication.dto.UserDTO;

public interface UserService {
    public void criptografarSenha(UserModel user) throws NoSuchAlgorithmException, UnsupportedEncodingException;

    public boolean verificarSenha(String senha, String senhaCriptografada) throws NoSuchAlgorithmException, UnsupportedEncodingException;

    public UserModel getUserByUsername(String username);

    public UserModel salvarUser(UserModel userModel);

    public List<UserModel> getAllUsers();

    public UserModel update(UserDTO userDTO);

    public String delete(UserDTO userDTO);
}
