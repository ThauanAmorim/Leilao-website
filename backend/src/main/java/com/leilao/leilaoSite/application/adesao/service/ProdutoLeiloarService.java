package com.leilao.leilaoSite.application.adesao.service;

import java.util.ArrayList;
import java.util.List;

import com.leilao.leilaoSite.domain.leilao.model.ProdutoModel;
import com.leilao.leilaoSite.domain.leilao.model.UserModel;
import com.leilao.leilaoSite.infrastructure.persistence.repository.produto.ProdutoLeiloarRepository;
import com.leilao.leilaoSite.infrastructure.persistence.repository.user.UserRepository;
import com.leilao.leilaoSite.presentation.produto.dto.ProdutoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class ProdutoLeiloarService{

    @Autowired
    private ProdutoLeiloarRepository produtoLeiloarRepository;

    @Autowired
    private UserRepository userRepository;

    public List<ProdutoModel> getAllProduto() {
        return produtoLeiloarRepository.findAll();
    }

    public ProdutoModel findProductByName(String name) {
        return this.produtoLeiloarRepository.findProductByName(name);
    }

    public List<ProdutoModel> findByUser(String username) throws NotFoundException {

        List<ProdutoModel> listaProdutos = userRepository.findByUsername(username).getProdutosLeiloar();
        if(listaProdutos.isEmpty()) throw new NotFoundException("Não encontrado");

        return listaProdutos;
    }

    public ProdutoModel salvarProduto(ProdutoDTO produtodto) {
        ProdutoModel produto = new ProdutoModel(produtodto);
        UserModel userRecuperado = userRepository.findByUsername(produtodto.getUsername());

        userRecuperado.addProdutoLeiloar(produto);

        userRepository.save(userRecuperado);
        return produto;
    }

    public ProdutoModel update(ProdutoDTO produtoLeiloarDTO) {
        ProdutoModel produto = produtoLeiloarRepository.getById(produtoLeiloarDTO.getId());

        if(produtoLeiloarDTO.getNome()!=null){
            produto.setNome(produtoLeiloarDTO.getNome());
        }

        return produtoLeiloarRepository.save(produto);
    }

    public String delete(Long id) {
        produtoLeiloarRepository.deleteById(id);
        return "Produto Deletado";
    }
}
