package com.devtheus.desafio_itau.controllers;

import com.devtheus.desafio_itau.controllers.dto.TransacaoRequestDto;
import com.devtheus.desafio_itau.service.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/transacao")
@RequiredArgsConstructor
@Tag(name = "API de transação", description = "Operações de criação e exclusão de transações")
public class TransacaoController {
    private final TransacaoService transacaoService;

    @PostMapping
    @Operation(summary = "Criar transação", description = "Endpoint para criar transação")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cria uma nova transação com sucesso"),
            @ApiResponse(responseCode = "422", description = "Erro de validação nos campos da transação"),
            @ApiResponse(responseCode = "400", description = "Erro de requisição"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<Void> criarTransacao(@RequestBody @Valid TransacaoRequestDto dto) {
        this.transacaoService.criarTransacao(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transação deletadas com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de requisição"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @Operation(summary = "Excluir transações", description = "Endpoint para excluir toda a lista de transações")
    public ResponseEntity<Void> deletarTransacoes() {
        this.transacaoService.limparLista();
        return ResponseEntity.ok().build();
    }
}
