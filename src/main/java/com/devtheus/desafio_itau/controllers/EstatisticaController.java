package com.devtheus.desafio_itau.controllers;

import com.devtheus.desafio_itau.controllers.dto.EstatisticaResponseDto;
import com.devtheus.desafio_itau.service.EstatisticaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/estatistica")
@RequiredArgsConstructor
@Tag(name = "API de estatistica", description = "Operação de recuperação de estatisticas")
public class EstatisticaController {
    private final EstatisticaService estatisticaService;

    @GetMapping
    @Operation(summary = "Gerar estatistica", description = "Endpoint para gerar campos de estatistica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recupera as estatisticas com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de requisição"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<EstatisticaResponseDto> buscarEstatisticas(@Parameter(description = "Intervalo de tempo", required = false, example = "120") @RequestParam(value = "intervalo", required = false, defaultValue = "60") Integer intervalo) {
        return ResponseEntity.status(HttpStatus.OK).body(this.estatisticaService.gerarEstatisticas(intervalo));
    }
}
