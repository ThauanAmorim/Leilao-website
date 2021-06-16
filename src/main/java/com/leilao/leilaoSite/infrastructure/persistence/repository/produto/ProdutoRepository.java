package com.leilao.leilaoSite.infrastructure.persistence.repository.produto;

import org.springframework.stereotype.Repository;

import com.leilao.leilaoSite.domain.leilao.model.ProdutoModel;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{
    
}
