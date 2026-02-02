package com.amanda.estoqueAPI.controller.dto;

import com.amanda.estoqueAPI.model.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoDTO(
        UUID id,

        //Tratamento dos campos
        @NotBlank (message = "Campo obrigatório")
        @Size (max = 100, min=1, message = "Campo fora do tamanho")
        String nome,

        @NotBlank (message = "Campo obrigatório")
        @Size (max= 20, min = 1, message = "Campo fora do tamanho")
        String tamanho,

        @NotNull (message = "Campo obrigatório")
        @Positive (message = "O valor deve ser positivo")
        Integer quantidade,

        @NotNull (message = "Campo obrigatório")
        @Positive (message = "O valor deve ser positivo")
        BigDecimal preco
) {

    //Metodo para mapear do DTO para a entidade
    public Produto mapearParaProduto (){
        Produto produto = new Produto();
        produto.setNome(this.nome);
        produto.setTamanho(this.tamanho);
        produto.setQuantidade(this.quantidade);
        produto.setPreco(this.preco);

        return produto;
    }
}
