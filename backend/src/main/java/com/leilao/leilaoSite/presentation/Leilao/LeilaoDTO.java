package com.leilao.leilaoSite.presentation.Leilao;

import java.time.LocalDateTime;
import java.util.List;

public class LeilaoDTO {
    private float valorInicial;
    private float valorMeta;
    private float valorAtual;
    private String usernameDono;
    private String usernameUltimoLance;
    private String descricao;
    private Long categoria;
    private LocalDateTime dataInicio;
    private LocalDateTime dataTermino;
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
    public LocalDateTime getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }
    public LocalDateTime getDataTermino() {
        return dataTermino;
    }
    public void setDataTermino(LocalDateTime dataTermino) {
        this.dataTermino = dataTermino;
    }
    public float getValorAtual() {
        return valorAtual;
    }
    public void setValorAtual(float valorAtual) {
        this.valorAtual = valorAtual;
    }
    public String getUsernameUltimoLance() {
        return usernameUltimoLance;
    }
    public void setUsernameUltimoLance(String usernameUltimoLance) {
        this.usernameUltimoLance = usernameUltimoLance;
    }
}
