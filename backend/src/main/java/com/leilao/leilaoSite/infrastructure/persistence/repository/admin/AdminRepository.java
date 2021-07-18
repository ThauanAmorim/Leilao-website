package com.leilao.leilaoSite.infrastructure.persistence.repository.admin;

import java.util.List;

import com.leilao.leilaoSite.domain.leilao.model.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<UserModel, Long> {

    @Override
    @Query("SELECT u FROM UserModel u WHERE u.isAdmin = true")
    public List<UserModel> findAll();

    @Query("SELECT u FROM UserModel u WHERE u.username = :username and u.isAdmin = true")
    public UserModel findByUsername(@Param("username") String username);

}
