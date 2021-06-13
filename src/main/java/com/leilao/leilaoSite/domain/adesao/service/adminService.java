package com.leilao.leilaoSite.domain.adesao.service;

import java.util.List;

import com.leilao.leilaoSite.domain.adesao.model.ModeloAdmin;

public interface adminService {
    public ModeloAdmin getAdminByUsername(String username);

    public ModeloAdmin salvarUser(ModeloAdmin modeloAdmin);

    public List<ModeloAdmin> getAllUsers();
}
