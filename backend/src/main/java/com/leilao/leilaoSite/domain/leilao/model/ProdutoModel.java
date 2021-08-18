package com.leilao.leilaoSite.domain.leilao.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.leilao.leilaoSite.presentation.produto.dto.ProdutoDTO;

@Entity
@Table(name = "TB_PRODUTO")
public class ProdutoModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "ARREMATADO")
    private boolean arrematado;

    @Column(name = "LEILOADO")
    private boolean leiloado = false;

    @Column(name = "DATA_ARREMATADO")
    private LocalDateTime dataArrematado;

    @Column(name = "DATA_REGISTRO")
    private LocalDateTime dataRegistro;

    public ProdutoModel(ProdutoDTO produtoDTO) {
        this.nome = produtoDTO.getNome();
        this.arrematado = false;
        this.dataArrematado = null;
        this.dataRegistro = LocalDateTime.now();
    }

    public ProdutoModel(){

    }

    public ProdutoModel(long id, String nome, boolean arrematado, LocalDateTime dataArrematado, LocalDateTime dataRegistro, boolean leiloado) {
        this.id = id;
        this.nome = nome;
        this.arrematado = arrematado;
        this.dataArrematado = dataArrematado;
        this.dataRegistro = dataRegistro;
        this.leiloado = leiloado;
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

    public void setLeiloado(boolean estado) {
        this.leiloado = estado;
    }

    public boolean isLeiloado() {
        return this.leiloado;
    }
}
