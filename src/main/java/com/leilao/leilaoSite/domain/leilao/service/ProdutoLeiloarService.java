package com.leilao.leilaoSite.domain.leilao.service;

import com.leilao.leilaoSite.domain.leilao.model.ProdutoModel;
import com.leilao.leilaoSite.presentation.produto.dto.ProdutoDTO;

public interface ProdutoLeiloarService extends ProdutoService {
    public ProdutoModel salvarProduto(ProdutoDTO produto);

    public ProdutoModel update(ProdutoDTO produtoDTO);

    public String delete(Long id);
}
