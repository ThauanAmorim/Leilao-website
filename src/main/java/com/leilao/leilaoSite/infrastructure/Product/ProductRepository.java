package com.leilao.leilaoSite.infrastructure.Product;

import com.leilao.leilaoSite.domain.leilao.model.ModeloProduto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ModeloProduto, Long>{
    @Query("SELECT tb_product FROM ModeloProduto tb_product WHERE tb_product.nome = :nome") 
    public ModeloProduto findProductByName(@Param("nome") String nome);
}
