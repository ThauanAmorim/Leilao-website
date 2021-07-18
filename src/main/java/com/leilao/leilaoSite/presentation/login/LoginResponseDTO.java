package com.leilao.leilaoSite.presentation.login;

public class LoginResponseDTO {
    private String response;
    
    public LoginResponseDTO() {
    }

    public LoginResponseDTO(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
