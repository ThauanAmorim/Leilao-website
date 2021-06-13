package com.leilao.leilaoSite.domain.adesao.service;

import java.util.List;

import com.leilao.leilaoSite.domain.adesao.model.UserModel;

public interface adminService {
    public List<UserModel> getAllAdmins();

    public UserModel getAdminByUsername(String username);

    public UserModel saveAdmin(UserModel userModel);

    public UserModel saveAdminByUsername(String username);

}
