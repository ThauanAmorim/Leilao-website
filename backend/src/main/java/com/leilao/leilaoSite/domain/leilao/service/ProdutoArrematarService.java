package com.leilao.leilaoSite.domain.leilao.service;

import com.leilao.leilaoSite.domain.leilao.model.ProdutoModel;
import com.leilao.leilaoSite.presentation.produto.dto.ProdutoArrematadoDTO;

public interface ProdutoArrematarService extends ProdutoService {
    
    public ProdutoModel salvarProduto(ProdutoArrematadoDTO produto);
    
}
