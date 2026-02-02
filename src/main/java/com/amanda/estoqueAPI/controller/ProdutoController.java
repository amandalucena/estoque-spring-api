package com.amanda.estoqueAPI.controller;

import com.amanda.estoqueAPI.controller.dto.ProdutoDTO;
import com.amanda.estoqueAPI.exceptions.ExceptionValidacao;
import com.amanda.estoqueAPI.model.Produto;
import com.amanda.estoqueAPI.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping ("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;


    //Cadastro de Produto
   @PostMapping
   public ResponseEntity<Object> salvar(@RequestBody  @Valid ProdutoDTO produto) {


       Produto produtoEntidade = produto.mapearParaProduto();
       service.salvar(produtoEntidade);

       URI location = ServletUriComponentsBuilder
                   .fromCurrentRequest()
                   .path("/{id}")
                   .buildAndExpand(produtoEntidade.getId())
                   .toUri();

       return ResponseEntity.created(location).build();

    }


    //Obter detalhes a partir do ID
    @GetMapping ("{id}")
    public ResponseEntity <ProdutoDTO> obterDetalhes (@PathVariable ("id") String id){
       var idProduto = UUID.fromString(id);
        Optional <Produto> produto = service.ObterPorId(idProduto);

        if (produto.isPresent()){
            Produto entidade = produto.get();
            ProdutoDTO dto = new ProdutoDTO(
                    produto.get().getId(),
                    produto.get().getNome(),
                    produto.get().getTamanho(),
                    produto.get().getQuantidade(),
                    produto.get().getPreco()
            );

            return ResponseEntity.ok(dto);
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping ("{id}")
    public ResponseEntity <Object> deletar (@PathVariable ("id") String id){

       var idProduto = UUID.fromString(id);
       Optional <Produto> produtoOptional = service.ObterPorId(idProduto);

       service.deletar(produtoOptional.get());
       return ResponseEntity.noContent().build();

    }




}
