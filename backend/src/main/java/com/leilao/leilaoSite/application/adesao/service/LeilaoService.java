package com.leilao.leilaoSite.application.adesao.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.leilao.leilaoSite.domain.leilao.model.CategoriaModel;
import com.leilao.leilaoSite.domain.leilao.model.LeilaoModel;
import com.leilao.leilaoSite.domain.leilao.model.ProdutoModel;
import com.leilao.leilaoSite.domain.leilao.model.UserModel;
import com.leilao.leilaoSite.infrastructure.exceptions.DadosObrigatoriosFaltandoException;
import com.leilao.leilaoSite.infrastructure.exceptions.NaoEncontradoException;
import com.leilao.leilaoSite.infrastructure.persistence.repository.categoria.CategoriaRepository;
import com.leilao.leilaoSite.infrastructure.persistence.repository.leilao.LeilaoRepository;
import com.leilao.leilaoSite.infrastructure.persistence.repository.produto.ProdutoLeiloarRepository;
import com.leilao.leilaoSite.infrastructure.persistence.repository.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeilaoService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LeilaoRepository leilaoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoLeiloarRepository produtoLeiloarRepository;

    public UserModel salvar(LeilaoModel leilaoModel, List<Long> listaDeIdsProdutos, long categoriaId, String username) throws DadosObrigatoriosFaltandoException, NaoEncontradoException {
        if(leilaoModel.getDataInicio() == null ||
        listaDeIdsProdutos == null ||
        leilaoModel.getDataTermino() == null ||
        categoriaId == 0) throw new DadosObrigatoriosFaltandoException();

        Optional<CategoriaModel> categoriaModel = categoriaRepository.findById(categoriaId);
        if(categoriaModel.get() == null) throw new NaoEncontradoException();

        leilaoModel.setCategoria(categoriaModel.get());

        for(Long i : listaDeIdsProdutos) {
            Optional<ProdutoModel> produto = produtoLeiloarRepository.findById(i);
            produto.get().setLeiloado(true);
            if(produto.get() == null) throw new NaoEncontradoException();
            
            leilaoModel.addProduto(produto.get());
        }
        UserModel user = userRepository.findByUsername(username);
        user.addLeilao(leilaoModel);
        return userRepository.save(user);
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
