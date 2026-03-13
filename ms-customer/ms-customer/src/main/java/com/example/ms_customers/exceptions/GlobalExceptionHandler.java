package com.example.ms_customers.exceptions;

import com.example.ms_customers.dtos.ErrorResponseDTO;
import com.example.ms_customers.exceptions.CustomApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Aquí atrapamos nuestra excepción personalizada
    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<ErrorResponseDTO> handleCustomException(CustomApiException ex) {
        ErrorResponseDTO error = ErrorResponseDTO.builder()
                .message(ex.getMessage())
                .code(ex.getStatus().value())
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(error, ex.getStatus());
    }

    // Aquí atrapamos cualquier otro error inesperado (NullPointer, etc.)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGeneralException(Exception ex) {
        ErrorResponseDTO error = ErrorResponseDTO.builder()
                .message("Ocurrió un error interno inesperado: " + ex.getMessage())
                .code(500)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.internalServerError().body(error);
    }
}