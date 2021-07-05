package com.leilao.leilaoSite.domain.leilao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categoria {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "CATEGORIA_NOME")
    private String categoriaNome;

    public Categoria() {
    }

    public Categoria(Long id, String categoriaNome) {
        this.id = id;
        this.categoriaNome = categoriaNome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }
}
