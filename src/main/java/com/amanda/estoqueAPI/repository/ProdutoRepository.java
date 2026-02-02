package com.amanda.estoqueAPI.repository;

import com.amanda.estoqueAPI.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

    List<Produto> findByNome (String nome);
    List <Produto> findByTamanho (String tamanho);
    List <Produto> findByQuantidade (Integer quantidade);
    List <Produto> findByPreco (BigDecimal preco);

    List <Produto> findByNomeAndTamanho (
            String nome,
            String tamanho
    );


    List<Produto> findByNomeAndTamanhoAndQuantidade(
            String nome,
            String tamanho,
            Integer quantidade
    );

    Optional <Produto> findByNomeAndTamanhoAndQuantidadeAndPreco(
            String nome,
            String tamanho,
            Integer quantidade,
            BigDecimal preco
    );
}
