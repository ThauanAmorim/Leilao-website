package com.leilao.leilaoSite.application.adesao.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.leilao.leilaoSite.domain.adesao.model.UserModel;
import com.leilao.leilaoSite.domain.adesao.service.UserService;
import com.leilao.leilaoSite.infrastructure.persistence.repository.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void criptografarSenha(UserModel user) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        user.setPassword(shar256(user.getPassword()));
    }

    @Override
    public boolean verificarSenha(String senha, String senhaCriptografada) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return senhaCriptografada.equals(shar256(senha));
    }
    
    private String shar256(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
        return messageDigest.toString();
    }

    @Override
    public UserModel getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserModel salvarUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }
}
