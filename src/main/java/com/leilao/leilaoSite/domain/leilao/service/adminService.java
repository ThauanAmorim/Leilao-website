package com.leilao.leilaoSite.domain.leilao.service;

import java.util.List;

import com.leilao.leilaoSite.domain.leilao.model.UserModel;

public interface adminService {
    public List<UserModel> getAllAdmins();

    public UserModel getAdminByUsername(String username);

    public UserModel saveAdmin(UserModel userModel);

    public UserModel saveAdminByUsername(String username);

}
