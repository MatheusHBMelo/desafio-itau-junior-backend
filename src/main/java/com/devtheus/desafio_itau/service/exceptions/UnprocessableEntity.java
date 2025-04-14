package com.devtheus.desafio_itau.service.exceptions;

import java.io.Serial;

public class UnprocessableEntity extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public UnprocessableEntity(String message) {
        super(message);
    }
}
