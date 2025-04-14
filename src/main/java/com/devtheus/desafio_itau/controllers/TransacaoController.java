package com.devtheus.desafio_itau.controllers;

import com.devtheus.desafio_itau.controllers.dto.TransacaoRequestDto;
import com.devtheus.desafio_itau.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/transacao")
@RequiredArgsConstructor
public class TransacaoController {
    private final TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<Void> criarTransacao(@RequestBody TransacaoRequestDto dto) {
        this.transacaoService.criarTransacao(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarTransacoes() {
        this.transacaoService.limparLista();
        return ResponseEntity.ok().build();
    }
}
