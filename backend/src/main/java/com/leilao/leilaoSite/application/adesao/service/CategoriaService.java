package com.leilao.leilaoSite.application.adesao.service;

import java.util.List;

import com.leilao.leilaoSite.application.adesao.service.AdminService;
import com.leilao.leilaoSite.domain.leilao.model.CategoriaModel;
import com.leilao.leilaoSite.domain.leilao.model.UserModel;
import com.leilao.leilaoSite.infrastructure.persistence.repository.categoria.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void salvar(CategoriaModel categoria) throws Exception{
        if(categoria.getCategoriaNome!=null){
            categoriaRepository.save(categoria);
        }
        throw new Exception();
    }

    
    public CategoriaModel recuperarPeloId(Long idCategoria){
        return categoriaRepository.findById(idCategoria);
    }

    public CategoriaModel recuperaTodasCategorias(){
        return categoriaRepository.findAll();
    }
}
