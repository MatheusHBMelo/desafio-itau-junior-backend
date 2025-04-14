package com.devtheus.desafio_itau.controllers.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "DTO de estatistica", description = "Record que armazena estatisticas das transações")
public record EstatisticaResponseDto(@Schema(description = "Contagem total de estatisticas", example = "10") Long count,
                                     @Schema(description = "Soma dos valores das transações em certo tempo", example = "110.0") Double sum,
                                     @Schema(description = "Média entre os valores das transações em certo tempo", example = "25.5") Double avg,
                                     @Schema(description = "Transação com o menor valor", example = "10") Double min,
                                     @Schema(description = "Transação com o maior valor", example = "100") Double max) {
}
