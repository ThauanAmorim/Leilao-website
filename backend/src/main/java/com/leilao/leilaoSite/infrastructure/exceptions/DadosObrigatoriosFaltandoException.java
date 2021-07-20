package com.leilao.leilaoSite.infrastructure.exceptions;

public class DadosObrigatoriosFaltandoException extends Exception {

    public DadosObrigatoriosFaltandoException() {
    }

    @Override
    public String getMessage() {
        return "dados importantes faltando";    }
    
}
