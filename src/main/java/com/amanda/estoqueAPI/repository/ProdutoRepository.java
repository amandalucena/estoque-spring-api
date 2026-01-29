package com.amanda.estoqueAPI.repository;

import com.amanda.estoqueAPI.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

    List<Produto> findByNome (String nome);
    List <Produto> findByTamanho (String tamanho);
    List <Produto> findByQuantidade (int quantidade);

    Optional <Produto> findByNomeAndTamanhoAndQuantidade(
            String nome,
            String tamanho,
            int quantidade
    );
}
