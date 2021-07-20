package com.leilao.leilaoSite.infrastructure.persistence.repository.leilao;

import com.leilao.leilaoSite.domain.leilao.model.LeilaoModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LeilaoRepository extends JpaRepository<LeilaoModel, Long> {
    
}
