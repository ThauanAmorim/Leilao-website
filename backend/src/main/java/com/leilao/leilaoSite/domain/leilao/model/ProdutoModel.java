package com.leilao.leilaoSite.domain.leilao.model;

import java.io.Serializable;
import java.util.Date;

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

    @Column(name = "DATA_ARREMATADO")
    private Date dataArrematado;

    @Column(name = "DATA_REGISTRO")
    private Date dataRegistro;

    public ProdutoModel(ProdutoDTO produtoDTO) {
        this.nome = produtoDTO.getNome();
        this.arrematado = false;
        this.dataArrematado = null;
        this.dataRegistro = new Date(System.currentTimeMillis());
    }

    public ProdutoModel(){

    }

    public ProdutoModel(long id, String nome, boolean arrematado, Date dataArrematado, Date dataRegistro) {
        this.id = id;
        this.nome = nome;
        this.arrematado = arrematado;
        this.dataArrematado = dataArrematado;
        this.dataRegistro = dataRegistro;
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

    public Date getDataArrematado() {
        return dataArrematado;
    }

    public void setDataArrematado(Date dataArrematado) {
        this.dataArrematado = dataArrematado;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
