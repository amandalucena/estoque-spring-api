package com.amanda.estoqueAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/produto")
public class TestController {

    @GetMapping
    public String teste (){
        return "Api rodando com sucesso";
    }
}
