package com.leilao.leilaoSite.application.adesao.service;

import java.util.List;

import com.leilao.leilaoSite.domain.leilao.model.ProdutoModel;
import com.leilao.leilaoSite.domain.leilao.model.UserModel;
import com.leilao.leilaoSite.domain.leilao.service.ProdutoLeiloarService;
import com.leilao.leilaoSite.domain.leilao.service.ProdutoService;
import com.leilao.leilaoSite.infrastructure.persistence.repository.produto.ProdutoLeiloarRepository;
import com.leilao.leilaoSite.infrastructure.persistence.repository.user.UserRepository;
import com.leilao.leilaoSite.presentation.produto.dto.ProdutoArrematadoDTO;
import com.leilao.leilaoSite.presentation.produto.dto.ProdutoLeiloarDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoLeiloarServiceImpl implements ProdutoLeiloarService {

    @Autowired
    private ProdutoLeiloarRepository produtoLeiloarRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ProdutoModel> getAllProduto(String name) {
        return produtoLeiloarRepository.findAll();
    }

    @Override
    public ProdutoModel findProductByName(String name) {
        return this.produtoLeiloarRepository.findProductByName(name);
    }

    @Override
    public ProdutoModel salvarProduto(ProdutoLeiloarDTO produtodto) {
        ProdutoModel produto = new ProdutoModel(produtodto);
        UserModel userRecuperado = userRepository.findByUsername(produtodto.getUsername());
        
        userRecuperado.addProdutosLeiloar(produto);

        userRepository.save(userRecuperado);
        return produto;
    }
}
