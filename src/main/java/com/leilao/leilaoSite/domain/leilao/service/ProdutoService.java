package com.leilao.leilaoSite.domain.leilao.service;

import java.util.List;
import com.leilao.leilaoSite.domain.leilao.model.ProdutoModel;

public interface ProdutoService {
    public ProdutoModel findProductByName(String name);

    public List<ProdutoModel> getAllProduto(String name);

}
