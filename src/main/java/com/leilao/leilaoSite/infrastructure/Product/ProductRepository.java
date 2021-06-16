package com.leilao.leilaoSite.infrastructure.Product;

import com.leilao.leilaoSite.domain.leilao.model.ProdutoModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProdutoModel, Long>{
    @Query("SELECT tb_product FROM ProdutoModel tb_product WHERE tb_product.name = :name") 
    public ProdutoModel findProductByName(@Param("name") String name);
}
