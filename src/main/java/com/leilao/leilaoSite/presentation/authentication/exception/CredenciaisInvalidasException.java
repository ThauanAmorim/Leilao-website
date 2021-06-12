package com.leilao.leilaoSite.presentation.authentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CredenciaisInvalidasException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Credenciais Inválidas";
    }
    
}
