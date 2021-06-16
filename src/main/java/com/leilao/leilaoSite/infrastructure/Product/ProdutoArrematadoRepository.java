package com.leilao.leilaoSite.infrastructure.Product;

import com.leilao.leilaoSite.domain.leilao.model.ProdutoModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoArrematadoRepository extends JpaRepository<ProdutoModel, Long>{
    @Query("SELECT p FROM ProdutoModel p WHERE p.nome = :nome") 
    public ProdutoModel findProductByName(@Param("nome") String nome);
}
