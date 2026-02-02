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

@RestController
@RequestMapping ("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;


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


    @GetMapping
    public String teste() {
        return "API OK";
    }


}
