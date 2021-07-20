package com.leilao.leilaoSite.application.adesao.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.leilao.leilaoSite.domain.leilao.model.LeilaoModel;
import com.leilao.leilaoSite.domain.leilao.model.ProdutoModel;
import com.leilao.leilaoSite.infrastructure.exceptions.DadosObrigatoriosFaltandoException;
import com.leilao.leilaoSite.infrastructure.exceptions.NaoEncontradoException;
import com.leilao.leilaoSite.infrastructure.persistence.repository.leilao.LeilaoRepository;
import com.leilao.leilaoSite.infrastructure.persistence.repository.produto.ProdutoLeiloarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeilaoService {
    @Autowired
    private LeilaoRepository leilaoRepository;
    @Autowired
    private ProdutoLeiloarRepository produtoLeiloarRepository;

    public LeilaoModel salvar(LeilaoModel leilaoModel, ArrayList<Long> listaDeIdsProdutos) throws DadosObrigatoriosFaltandoException, NaoEncontradoException {
        if(leilaoModel.getCategoria() == null ||
        leilaoModel.getDataInicio() == null ||
        leilaoModel.getListaProdutos() == null) throw new DadosObrigatoriosFaltandoException();

        for(Long i : listaDeIdsProdutos) {
            Optional<ProdutoModel> produto = produtoLeiloarRepository.findById(i);
            if(produto.get() == null) throw new NaoEncontradoException();
            
            leilaoModel.addProduto(produto.get());
        }

        return leilaoRepository.save(leilaoModel);
    }

    public LeilaoModel get(Long id) throws NaoEncontradoException {
        LeilaoModel leilao = leilaoRepository.getById(id);

        if(leilao == null) throw new NaoEncontradoException();
        
        return leilao;
    }

    public List<LeilaoModel> get() throws NaoEncontradoException {
        List<LeilaoModel> lista = leilaoRepository.findAll();

        if(lista == null || lista.isEmpty()) throw new NaoEncontradoException();

        return lista;
    }

    public void delete(Long id) throws NaoEncontradoException {
        LeilaoModel leilao = leilaoRepository.getById(id);

        if(leilao == null) throw new NaoEncontradoException();
        
        leilaoRepository.delete(leilao);
    }
    
}
