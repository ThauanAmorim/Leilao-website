package com.leilao.leilaoSite.presentation.authentication.dto;

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
