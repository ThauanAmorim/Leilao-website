package com.leilao.leilaoSite.application.adesao.service;

import java.util.List;

import com.leilao.leilaoSite.domain.leilao.model.ProdutoModel;
import com.leilao.leilaoSite.domain.leilao.model.UserModel;
import com.leilao.leilaoSite.domain.leilao.service.ProdutoService;
import com.leilao.leilaoSite.infrastructure.persistence.repository.produto.ProdutoArrematadoRepository;
import com.leilao.leilaoSite.infrastructure.persistence.repository.user.UserRepository;
import com.leilao.leilaoSite.presentation.produto.dto.ProdutoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoArrematadoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoArrematadoRepository produtoArrematadoRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ProdutoModel findProductByName(String name) {
        return this.produtoArrematadoRepository.findProductByName(name);
    }

    @Override
    public List<ProdutoModel> getAllProduto(String name) {
        return produtoArrematadoRepository.findAll();
    }

    @Override
    public ProdutoModel salvarProduto(ProdutoDTO produtodto) {
        ProdutoModel produtoModel = produtoArrematadoRepository.findProductByName(produtodto.getNome());
        if(produtoModel!=null){
            UserModel userModel = userRepository.findByUsername(produtodto.getUsername());
    
            userModel.addProdutoArrematado(produtoModel);
            
            userRepository.update(userModel.getProdutosArrematado(), userModel.getId(),userModel.getUsername());
            return produtoModel;
        }

        return null;
    }
    
}
