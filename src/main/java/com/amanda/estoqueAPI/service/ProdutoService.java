package com.amanda.estoqueAPI.service;

import com.amanda.estoqueAPI.model.Produto;
import com.amanda.estoqueAPI.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;


    public Produto salvar (Produto produto){
        return produtoRepository.save (produto);
    }




}
