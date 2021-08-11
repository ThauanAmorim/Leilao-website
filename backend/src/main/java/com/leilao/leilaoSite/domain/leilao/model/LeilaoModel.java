package com.leilao.leilaoSite.domain.leilao.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.leilao.leilaoSite.presentation.leilao.LeilaoDTO;

@Entity
@Table(name = "TB_LEILAO")
public class LeilaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "DATA_REGISTRO")
    private LocalDateTime dataRegistro;
    @Column(name = "DATA_INICIO")
    private LocalDateTime dataInicio;
    @Column(name = "DATA_TERMINO")
    private LocalDateTime dataTermino;
    @Column(name = "VALOR_INICIAL")
    private float valorInicial;
    @Column(name = "VALOR_ATUAL")
    private float valorAtual;
    @Column(name = "USERNAME_ULTIMO_LANCE")
    private String usernameUltimoLance;
    @Column(name = "VALOR_META")
    private float valorMeta;
    @Column(name = "DESCRICAO")
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "CATEGORIA_FK")
    private CategoriaModel categoria;
    @OneToMany
    @JoinColumn(name = "LISTA_PRODUTOS_FK")
    private List<ProdutoModel> listaProdutos;
    
    public LeilaoModel() {
        dataRegistro = LocalDateTime.now();
    }

    public LeilaoModel(LeilaoDTO dto) {
        this.dataRegistro = LocalDateTime.now();
        this.dataInicio = dto.getDataInicio();
        this.dataTermino = dto.getDataTermino();
        this.descricao = dto.getDescricao();
        this.valorInicial = dto.getValorInicial();
        this.valorMeta = dto.getValorMeta();
    }

    public LeilaoModel(Long id, LocalDateTime dataRegistro, LocalDateTime dataInicio, LocalDateTime dataTermino, float valorInicial,
            float valorAtual, String usernameUltimoLance, float valorMeta, String descricao, CategoriaModel categoria,
            List<ProdutoModel> listaProdutos) {
        this.id = id;
        this.dataRegistro = dataRegistro;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.valorInicial = valorInicial;
        this.valorAtual = valorAtual;
        this.usernameUltimoLance = usernameUltimoLance;
        this.valorMeta = valorMeta;
        this.descricao = descricao;
        this.categoria = categoria;
        this.listaProdutos = listaProdutos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public float getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(float valorInicial) {
        this.valorInicial = valorInicial;
    }

    public LocalDateTime getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDateTime dataTermino) {
        this.dataTermino = dataTermino;
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

    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }

    public List<ProdutoModel> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<ProdutoModel> listaProdutos) {
        this.listaProdutos = listaProdutos;
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

    public void addProduto(ProdutoModel produto) {
        if(listaProdutos == null) listaProdutos = new ArrayList<>();
        this.listaProdutos.add(produto);
    } 
}
