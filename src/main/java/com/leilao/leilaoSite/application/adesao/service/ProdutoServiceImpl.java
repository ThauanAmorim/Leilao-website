package com.leilao.leilaoSite.application.adesao.service;

import java.util.List;

import com.leilao.leilaoSite.domain.adesao.service.ProductService;
import com.leilao.leilaoSite.domain.leilao.model.ProdutoModel;
import com.leilao.leilaoSite.infrastructure.Product.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProductService{

    @Autowired
    private ProductRepository modeloProduto;

    @Override
    public List<ProdutoModel> getAllProduto(String name) {
        return modeloProduto.findAll();
    }

    @Override
    public ProdutoModel findProductByName(String name) {
        return this.modeloProduto.findProductByName(name);
    }

    @Override
    public ProdutoModel saveProduct(ProdutoModel product) {
        return this.modeloProduto.save(product);
    }
}
