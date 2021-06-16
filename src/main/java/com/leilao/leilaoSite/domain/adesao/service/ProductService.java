package com.leilao.leilaoSite.domain.adesao.service;

import java.util.List;
import com.leilao.leilaoSite.domain.leilao.model.ProdutoModel;

public interface ProductService {
    public ProdutoModel findProductByName(String name);

    public List<ProdutoModel> getAllProduto(String name);

    public ProdutoModel saveProduct(ProdutoModel product);
}
