package com.leilao.leilaoSite.domain.adesao.service;

import java.util.List;
import com.leilao.leilaoSite.domain.leilao.model.ModeloProduto;

public interface ProductService {
    public ModeloProduto findProductByName(String name);

    public List<ModeloProduto> getAllProduto(String name);

    public ModeloProduto saveProduct(ModeloProduto product);
}
