package com.amanda.estoqueAPI.controller.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

public record ErroResposta (int status, String message, List <CampoErro> erros) {

    public static ErroResposta respostaPadrao (String message){
        return new ErroResposta(HttpStatus.BAD_REQUEST.value(), message, List.of());
    }

    public static ErroResposta conflict (String message){
        return new ErroResposta(HttpStatus.CONFLICT.value(), message, List.of() );
    }

}
