package com.leilao.leilaoSite.presentation.leilao;

import java.sql.Date;
import java.util.List;

public class LeilaoDTO {
    private float valorInicial;
    private float valorMeta;
    private String usernameDono;
    private String descricao;
    private Long categoria;
    private Date dataInicio;
    private Date dataTermino;
    private List<Long> listaProdutos;

    public float getValorInicial() {
        return valorInicial;
    }
    public void setValorInicial(float valorInicial) {
        this.valorInicial = valorInicial;
    }
    public float getValorMeta() {
        return valorMeta;
    }
    public void setValorMeta(float valorMeta) {
        this.valorMeta = valorMeta;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Long getCategoria() {
        return categoria;
    }
    public void setCategoria(Long categoria) {
        this.categoria = categoria;
    }
    public List<Long> getListaProdutos() {
        return listaProdutos;
    }
    public void setListaProdutos(List<Long> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
    public String getUsernameDono() {
        return usernameDono;
    }
    public void setUsernameDono(String usernameDono) {
        this.usernameDono = usernameDono;
    }
    public Date getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    public Date getDataTermino() {
        return dataTermino;
    }
    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }
}
