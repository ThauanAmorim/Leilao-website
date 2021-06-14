package com.leilao.leilaoSite.domain.leilao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PRODUCT")
public class ModeloProduto implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DESCRIPTION")
    private String descricao;

    @Column(name = "PRECO")
    private float preco;

    public ModeloProduto(){

    }

    public ModeloProduto(String nome, String descricao, float preco){
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

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
