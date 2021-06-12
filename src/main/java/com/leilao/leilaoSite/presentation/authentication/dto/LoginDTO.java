package com.leilao.leilaoSite.presentation.authentication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class LoginDTO {
    private String username;
    private String senha;

    public LoginDTO() {
    }

    public LoginDTO(String username, String senha) {
        this.username = username;
        this.senha = senha;
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}
