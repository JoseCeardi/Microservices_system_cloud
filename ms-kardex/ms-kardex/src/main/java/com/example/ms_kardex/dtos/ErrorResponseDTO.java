package com.example.ms_kardex.dtos;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponseDTO {
    private String message;
    private int code;
    private LocalDateTime timestamp;
}