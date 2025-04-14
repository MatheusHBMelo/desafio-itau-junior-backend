package com.devtheus.desafio_itau.controllers.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.OffsetDateTime;

@Schema(name = "DTO de Transação", description = "Record que representa a transação")
public record TransacaoRequestDto(@Schema(description = "Valor da transação", example = "10") Double valor,
                                  @Schema(description = "Data e hora da transação em UTC", example = "2025-04-14T17:19:00Z") OffsetDateTime dataHora) {
}
