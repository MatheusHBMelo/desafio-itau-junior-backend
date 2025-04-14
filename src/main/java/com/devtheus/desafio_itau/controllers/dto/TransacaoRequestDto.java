package com.devtheus.desafio_itau.controllers.dto;

import java.time.OffsetDateTime;

public record TransacaoRequestDto(Double valor, OffsetDateTime dataHora) {
}
