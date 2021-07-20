package com.leilao.leilaoSite.infrastructure.exceptions;

public class NaoEncontradoException extends Exception{
    public NaoEncontradoException() {
    }
    
    @Override
    public String getMessage() {
        return "Não encontrado";
    }
}
