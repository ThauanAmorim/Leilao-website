package com.leilao.leilaoSite.application.adesao.service;

import java.util.List;

import com.leilao.leilaoSite.domain.leilao.model.UserModel;
import com.leilao.leilaoSite.infrastructure.persistence.repository.admin.AdminRepository;
import com.leilao.leilaoSite.infrastructure.persistence.repository.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private UserRepository userRepository;

    public UserModel getAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    public List<UserModel> getAllAdmins() {
        return adminRepository.findAll();
    }

    public UserModel saveAdmin(UserModel userModel) {
        userModel.setAdmin(true);
        return adminRepository.save(userModel);
    }

    public UserModel saveAdminByUsername(String username) {
        UserModel userModel = userRepository.findByUsername(username);

        if(userModel != null) {
            userModel.setAdmin(true);
            return adminRepository.save(userModel);
        }
        return null;
    }
    
}
