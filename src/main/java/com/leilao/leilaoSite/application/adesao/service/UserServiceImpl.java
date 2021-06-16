package com.leilao.leilaoSite.application.adesao.service;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.leilao.leilaoSite.domain.leilao.model.UserModel;
import com.leilao.leilaoSite.domain.leilao.service.UserService;
import com.leilao.leilaoSite.infrastructure.persistence.repository.user.UserRepository;
import com.leilao.leilaoSite.presentation.authentication.dto.UserDTO;

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
        MessageDigest messageDigest =  MessageDigest.getInstance("SHA-256");
        messageDigest.update(senha.getBytes("UTF-8"));
        return new BigInteger(1, messageDigest.digest()).toString(16);
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

    @Override
    public UserModel update(UserDTO userDTO) {
        UserModel user = userRepository.getById(userDTO.getId());

        if(userDTO.getUsername()!=null){
            user.setUsername(userDTO.getUsername());
        }
        if(userDTO.getEmail()!=null){
            user.setEmail(userDTO.getEmail());
        }
        if(userDTO.getPassword()!=null){
            try {
                user.setPassword(shar256(userDTO.getPassword()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(userDTO.getBirthday()!=null){
            user.setBirthday(userDTO.getBirthday());
        }
        return userRepository.save(user);
    }

    @Override
    public String delete(UserDTO userDTO) {
        Long id = userRepository.findByUsername(userDTO.getUsername()).getId();
        userRepository.deleteById(id);
        return "Usuario Deletado com Sucesso.";
    }  
}
