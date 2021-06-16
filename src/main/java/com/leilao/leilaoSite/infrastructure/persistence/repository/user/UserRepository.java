package com.leilao.leilaoSite.infrastructure.persistence.repository.user;

import java.util.List;

import com.leilao.leilaoSite.domain.leilao.model.ProdutoModel;
import com.leilao.leilaoSite.domain.leilao.model.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    @Query("SELECT u FROM UserModel u WHERE u.username = :username")
    public UserModel findByUsername(@Param("username") String username);

    @Modifying
    @Query("UPDATE UserModel u SET u.produtosArrematado = ?1 WHERE u.id = ?2")
    public UserModel update(List<ProdutoModel> produtoModels, Long id);
}
