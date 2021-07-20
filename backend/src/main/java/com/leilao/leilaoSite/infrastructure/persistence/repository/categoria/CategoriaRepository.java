package com.leilao.leilaoSite.infrastructure.persistence.repository.categoria;

import com.leilao.leilaoSite.domain.leilao.model.CategoriaModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{
    
}
