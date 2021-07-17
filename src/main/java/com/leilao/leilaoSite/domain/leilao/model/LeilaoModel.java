package com.leilao.leilaoSite.domain.leilao.model;

import java.util.Date;
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

@Entity
@Table(name = "TB_LEILAO")
public class LeilaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "DATA_REGISTRO")
    private Date dataRegistro;
    @Column(name = "DATA_INICIO")
    private Date dataInicio;
    @Column(name = "VALOR_INICIAL")
    private float valorInicial;
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
    }

    public LeilaoModel(Long id, Date dataRegistro, Date dataInicio, float valorInicial, float valorMeta,
            String descricao, CategoriaModel categoria, List<ProdutoModel> listaProdutos) {
        this.id = id;
        this.dataRegistro = dataRegistro;
        this.dataInicio = dataInicio;
        this.valorInicial = valorInicial;
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

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

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
}
