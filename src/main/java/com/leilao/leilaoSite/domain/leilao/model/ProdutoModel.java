package com.leilao.leilaoSite.domain.leilao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.leilao.leilaoSite.presentation.produto.dto.ProdutoLeiloarDTO;

@Entity
@Table(name = "TB_PRODUTO")
public class ProdutoModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "PRECO")
    private float preco;

    @Column(name = "ARREMATADO")
    private boolean arrematado;

    @Column(name = "DATA_ARREMATADO")
    private Date dataArrematado;

    @Column(name = "DATA_REGISTRO")
    private Date dataRegistro;

    public ProdutoModel(ProdutoLeiloarDTO produtoDTO) {
        this.nome = produtoDTO.getNomeProduto();
        this.descricao = produtoDTO.getDescricao();
        this.preco = produtoDTO.getPreco();
        this.arrematado = false;
        this.dataArrematado = null;
        this.dataRegistro = new Date(System.currentTimeMillis());
    }

    public ProdutoModel(){

    }

    public ProdutoModel(String nome, String descricao, float preco){
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        return result;
    }

    @Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descrição=" + descricao + "]";
	}

    public long getId(){
        return id;
    }

    public void setId(Long id) {
		this.id = id;
	}
    
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public float getpreco() {
        return preco;
    }

    public void setpreco(float preco) {
        this.preco = preco;
    }

    public void setArrematado(boolean arrametado){
        this.arrematado = arrametado;
    }

    public boolean isArrematado(){
        return this.arrematado;
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
