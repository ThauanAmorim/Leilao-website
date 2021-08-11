package com.leilao.leilaoSite.presentation.produto.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class ProdutoDTO implements Serializable{
    private long id;
    private String nome;
    private boolean arrematado;
    private LocalDateTime dataArrematado;
    private LocalDateTime dataRegistro;
    private String username;

    public ProdutoDTO(){

    }

    public ProdutoDTO(long id, String nome, boolean arrematado, LocalDateTime dataArrematado, LocalDateTime dataRegistro, String username) {
        this.id = id;
        this.nome = nome;
        this.arrematado = arrematado;
        this.dataArrematado = dataArrematado;
        this.dataRegistro = dataRegistro;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isArrematado() {
        return arrematado;
    }

    public void setArrematado(boolean arrematado) {
        this.arrematado = arrematado;
    }

    public LocalDateTime getDataArrematado() {
        return dataArrematado;
    }

    public void setDataArrematado(LocalDateTime dataArrematado) {
        this.dataArrematado = dataArrematado;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
