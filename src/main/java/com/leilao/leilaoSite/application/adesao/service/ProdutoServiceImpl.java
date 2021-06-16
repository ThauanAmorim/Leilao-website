package com.leilao.leilaoSite.application.adesao.service;

import java.util.List;

import com.leilao.leilaoSite.domain.adesao.service.ProdutoService;
import com.leilao.leilaoSite.domain.leilao.model.ProdutoModel;
import com.leilao.leilaoSite.infrastructure.Product.ProdutoArrematadoRepository;
import com.leilao.leilaoSite.presentation.produto.dto.ProdutoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    private ProdutoArrematadoRepository produtoArrematadoRepository;

    @Override
    public List<ProdutoModel> getAllProduto(String name) {
        return produtoArrematadoRepository.findAll();
    }

    @Override
    public ProdutoModel findProductByName(String name) {
        return this.produtoArrematadoRepository.findProductByName(name);
    }

    @Override
    public ProdutoModel salvarProduto(ProdutoDTO produtodto) {
        ProdutoModel produto = new ProdutoModel(produtodto);
        return this.produtoArrematadoRepository.save(produto);
    }
}
