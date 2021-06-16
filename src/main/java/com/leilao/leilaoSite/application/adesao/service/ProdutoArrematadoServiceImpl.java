package com.leilao.leilaoSite.application.adesao.service;

import java.util.List;

import com.leilao.leilaoSite.domain.leilao.model.ProdutoModel;
import com.leilao.leilaoSite.domain.leilao.model.UserModel;
import com.leilao.leilaoSite.domain.leilao.service.ProdutoService;
import com.leilao.leilaoSite.infrastructure.persistence.repository.produto.ProdutoArrematadoRepository;
import com.leilao.leilaoSite.infrastructure.persistence.repository.user.UserRepository;
import com.leilao.leilaoSite.presentation.produto.dto.ProdutoDTO;

import org.springframework.beans.factory.annotation.Autowired;

public class ProdutoArrematadoServiceImpl implements ProdutoService {
    @Autowired
    private ProdutoArrematadoRepository produtoArrematadoRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ProdutoModel findProductByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ProdutoModel> getAllProduto(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ProdutoModel salvarProduto(ProdutoDTO produtodto) {
        ProdutoModel produto = new ProdutoModel(produtodto);

        UserModel userRecuperado = userRepository.findByUsername(produtodto.getUsername());
        userRecuperado.addProdutoArrematado(produto);
        produto.setDonoProduto(userRecuperado);
        userRepository.save(userRecuperado);
        return null;
    }
    
}
