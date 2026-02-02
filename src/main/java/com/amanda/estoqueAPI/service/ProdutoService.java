package com.amanda.estoqueAPI.service;

import com.amanda.estoqueAPI.model.Produto;
import com.amanda.estoqueAPI.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;


    public Produto salvar (Produto produto){
        return produtoRepository.save (produto);
    }

    public Optional <Produto> ObterPorId (UUID id){
        return produtoRepository.findById(id);
    }




}
