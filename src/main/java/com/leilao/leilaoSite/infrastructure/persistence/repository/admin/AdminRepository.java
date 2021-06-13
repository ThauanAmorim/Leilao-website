package com.leilao.leilaoSite.infrastructure.persistence.repository.admin;

import com.leilao.leilaoSite.domain.adesao.model.ModeloAdmin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<ModeloAdmin, Long> {
    
}
