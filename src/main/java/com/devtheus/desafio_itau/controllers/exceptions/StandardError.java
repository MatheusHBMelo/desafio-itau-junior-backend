package com.devtheus.desafio_itau.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {
    private String message;
    private Integer code;
    private OffsetDateTime timestamp;
    private String path;
}
