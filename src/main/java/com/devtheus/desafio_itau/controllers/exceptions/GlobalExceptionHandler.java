package com.devtheus.desafio_itau.controllers.exceptions;

import com.devtheus.desafio_itau.service.exceptions.UnprocessableEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.OffsetDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UnprocessableEntity.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<StandardError> unprocessbleEntityException(UnprocessableEntity ex, WebRequest request) {
        StandardError error = new StandardError(ex.getMessage(),
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                OffsetDateTime.now(),
                request.getDescription(false)
                        .replace("uri=", ""));
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
    }
}
