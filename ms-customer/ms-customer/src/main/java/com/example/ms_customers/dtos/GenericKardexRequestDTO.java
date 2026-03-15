package com.example.ms_customers.dtos;

import com.example.ms_customers.enums.KardexMovementType;
import lombok.Data;

@Data
public class GenericKardexRequestDTO {
    private Long toolId;
    private Long loanId;
    private String rutClient;
    private KardexMovementType movementType;
    private String description;
    private Integer quantity;
    private String userResponsible;
    private String consecuencia;
}