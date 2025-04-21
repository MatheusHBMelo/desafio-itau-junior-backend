package com.devtheus.desafio_itau.controllers.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

@Schema(name = "DTO de Transação", description = "Record que representa a transação")
public record TransacaoRequestDto(@Schema(description = "Valor da transação") @NotNull(message = "O valor da transação não pode ser vazio.") Double valor,
                                  @Schema(description = "Data e hora da transação em UTC") @NotNull(message = "O valor do timestamp da transação não pode estar vazio.") OffsetDateTime dataHora) {
}
