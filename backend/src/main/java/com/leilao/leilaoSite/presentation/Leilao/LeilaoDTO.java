package com.leilao.leilaoSite.presentation.Leilao;

import java.util.List;

public class LeilaoDTO {
    private float valorInicial;
    private float valorMeta;
    private String descricao;
    private int categoria;
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
    public int getCategoria() {
        return categoria;
    }
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    public List<Long> getListaProdutos() {
        return listaProdutos;
    }
    public void setListaProdutos(List<Long> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
}
