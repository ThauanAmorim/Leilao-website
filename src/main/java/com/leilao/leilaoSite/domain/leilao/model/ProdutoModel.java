package com.leilao.leilaoSite.domain.leilao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.leilao.leilaoSite.presentation.produto.dto.ProdutoDTO;

@Entity
@Table(name = "TB_PRODUCT")
public class ProdutoModel implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String descricao;

    @Column(name = "PRICE")
    private float price;

    public ProdutoModel(ProdutoDTO produtoDTO) {
        
    }

    public ProdutoModel(){

    }

    public ProdutoModel(String name, String descricao, float price){
        this.name = name;
        this.descricao = descricao;
        this.price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        return result;
    }

    @Override
	public String toString() {
		return "Produto [id=" + id + ", name=" + name + ", descrição=" + descricao + "]";
	}

    public long getId(){
        return id;
    }

    public void setId(Long id) {
		this.id = id;
	}
    
    public String getNome(){
        return name;
    }

    public void setNome(String name){
        this.name = name;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public float getprice() {
        return price;
    }

    public void setprice(float price) {
        this.price = price;
    }
}
