package com.leilao.leilaoSite.infrastructure.persistence.repository.user;
import java.util.Optional;

import com.leilao.leilaoSite.domain.adesao.model.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{
    @Query("SELECT u FROM UserModel u WHERE u.username = :username")
    public UserModel findByUsername(@Param("username") String username);
}
