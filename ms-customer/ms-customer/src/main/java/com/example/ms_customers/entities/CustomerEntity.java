package com.example.ms_customers.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer", unique = true, nullable = false)
    private Long idCustomer;

    @Column(name="rut")
    private String rut;

    @Column(name="nombre")
    private String nombre;

    @Column(name="correo")
    private String correo;

    @Column(name="telefono")
    private String telefono;

    @Column(name="active")
    private Boolean active;

}
