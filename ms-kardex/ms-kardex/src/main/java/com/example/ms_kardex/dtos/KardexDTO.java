package com.example.ms_kardex.dtos;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class KardexDTO {
    private Long id;
    private Long toolId;
    private Long loanId;
    private String rutClient;
    private String movementType;
    private String description;
    private Integer quantity;
    private String userResponsible;
    private LocalDateTime date;
    private String consecuencia;
}