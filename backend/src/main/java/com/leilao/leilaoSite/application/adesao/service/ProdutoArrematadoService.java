package com.leilao.leilaoSite.application.adesao.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.leilao.leilaoSite.domain.leilao.model.ProdutoModel;
import com.leilao.leilaoSite.domain.leilao.model.UserModel;
import com.leilao.leilaoSite.infrastructure.persistence.repository.produto.ProdutoArrematadoRepository;
import com.leilao.leilaoSite.infrastructure.persistence.repository.user.UserRepository;
import com.leilao.leilaoSite.presentation.produto.dto.ProdutoArrematadoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoArrematadoService {

    @Autowired
    private ProdutoArrematadoRepository produtoArrematadoRepository;

    @Autowired
    private UserRepository userRepository;

    public ProdutoModel findProductByName(String name) {
        return this.produtoArrematadoRepository.findProductByName(name);
    }

    public List<ProdutoModel> getAllProduto(String name) {
        return produtoArrematadoRepository.findAll();
    }

    public ProdutoModel salvarProduto(ProdutoArrematadoDTO produtodto) {
        Optional<ProdutoModel> produtoModel = produtoArrematadoRepository.findById(produtodto.getId());

        if(produtoModel.get() != null){
            UserModel userModel = userRepository.findByUsername(produtodto.getUsername());

            produtoModel.get().setArrematado(true);
            produtoModel.get().setDataArrematado(new Date(System.currentTimeMillis()));
    
            userModel.addProdutoArrematado(produtoModel.get());

            userRepository.save(userModel);
            return produtoModel.get();
        }

        return null;
    }
    
}
