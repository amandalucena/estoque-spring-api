package com.amanda.estoqueAPI.service;

import com.amanda.estoqueAPI.model.Produto;
import com.amanda.estoqueAPI.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void deletar (Produto produto){
        produtoRepository.delete(produto);
    }


    public List<Produto> pesquisa (String nome, String tamanho, Integer quantidade){
        if (nome != null && tamanho != null && quantidade != null){
            return produtoRepository.findByNomeAndTamanhoAndQuantidade(nome, tamanho, quantidade);
        }

        if (nome != null && tamanho != null){
            return produtoRepository.findByNomeAndTamanho(nome, tamanho);
        }


        if (nome != null){
            return produtoRepository.findByNome(nome);
        }

        if (tamanho != null){
            return produtoRepository.findByTamanho(tamanho);
        }

        if (quantidade !=null){
            return produtoRepository.findByQuantidade(quantidade);
        }

        return produtoRepository.findAll();


    }

}
