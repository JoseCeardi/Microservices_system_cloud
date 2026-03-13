package com.example.ms_customers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    String rut;
    String nombre;
    String telefono;
    String correo;
    Boolean active;
}
