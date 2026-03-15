package com.example.ms_customers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String rut;
    private String nombre;
    private String telefono;
    private String correo;
    private Boolean active;
}