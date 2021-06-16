package com.leilao.leilaoSite.domain.leilao.service;

import com.leilao.leilaoSite.domain.leilao.model.ProdutoModel;
import com.leilao.leilaoSite.presentation.produto.dto.ProdutoLeiloarDTO;

public interface ProdutoLeiloarService extends ProdutoService {
    public ProdutoModel salvarProduto(ProdutoLeiloarDTO produto);
}
