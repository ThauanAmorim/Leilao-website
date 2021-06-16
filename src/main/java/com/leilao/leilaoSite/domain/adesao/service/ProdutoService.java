package com.leilao.leilaoSite.domain.adesao.service;

import java.util.List;
import com.leilao.leilaoSite.domain.leilao.model.ProdutoModel;
import com.leilao.leilaoSite.presentation.produto.dto.ProdutoDTO;

public interface ProdutoService {
    public ProdutoModel findProductByName(String name);

    public List<ProdutoModel> getAllProduto(String name);

    public ProdutoModel salvarProduto(ProdutoDTO produto);
}
