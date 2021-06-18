package com.leilao.leilaoSite.application.adesao.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import com.leilao.leilaoSite.application.adesao.service.UserServiceImpl;
import com.leilao.leilaoSite.domain.leilao.model.UserModel;
import com.leilao.leilaoSite.presentation.user.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping
    public ResponseEntity<UserModel> salvarUser(@RequestBody UserDTO userDTO) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        UserModel user = new UserModel(userDTO);
        userServiceImpl.criptografarSenha(user);
        UserModel userSalvo = userServiceImpl.salvarUser(user);

        if(userSalvo != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(userSalvo);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserModel> getUserByUsername(@PathVariable String username) {
        UserModel userModel = userServiceImpl.getUserByUsername(username);

        if(userModel != null) {
            return ResponseEntity.status(HttpStatus.OK).body(userModel);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getTodosUsers() {
        List<UserModel> userModels = userServiceImpl.getAllUsers();

        if(!userModels.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(userModels);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PatchMapping
    public UserModel update(@RequestBody UserDTO produtoDTO){
        return userServiceImpl.update(produtoDTO);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody UserDTO userDTO){
        String msg = userServiceImpl.delete(userDTO);

        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }
}
