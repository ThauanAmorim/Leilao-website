package com.leilao.leilaoSite.application.adesao.service;

import java.util.List;

import com.leilao.leilaoSite.domain.adesao.service.ProductService;
import com.leilao.leilaoSite.domain.leilao.model.ModeloProduto;
import com.leilao.leilaoSite.infrastructure.Product.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProductService{

    @Autowired
    private ProductRepository modeloProduto;

    @Override
    public List<ModeloProduto> getAllProduto(String name) {
        return modeloProduto.findAll();
    }

    @Override
    public ModeloProduto findProductByName(String name) {
        return this.modeloProduto.findProductByName(name);
    }

    @Override
    public ModeloProduto saveProduct(ModeloProduto product) {
        return this.modeloProduto.save(product);
    }
}
