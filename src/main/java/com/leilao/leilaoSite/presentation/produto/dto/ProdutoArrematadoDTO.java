package com.leilao.leilaoSite.presentation.produto.dto;

public class ProdutoArrematadoDTO {

    //username do comprador ou leiloador
    private String username;

    private Long id;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
