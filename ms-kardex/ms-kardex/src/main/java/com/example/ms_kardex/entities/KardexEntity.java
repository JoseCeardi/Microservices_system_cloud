package com.example.ms_kardex.entities;

import com.example.ms_kardex.enums.KardexMovementType;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "kardex")
public class KardexEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // --- Identificadores Opcionales (Dependen del evento) ---
    @Column(name = "tool_id")
    private Long toolId;

    @Column(name = "loan_id")
    private Long loanId;

    @Column(name = "rut_client")
    private String rutClient;

    // --- Datos Obligatorios del Evento ---
    @Enumerated(EnumType.STRING)
    @Column(name = "movement_type", nullable = false)
    private KardexMovementType movementType;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "quantity", nullable = false)
    private Integer quantity = 0;

    @Column(name = "user_responsible", nullable = false)
    private String userResponsible;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "consecuencia", columnDefinition = "TEXT")
    private String consecuencia;

    @PrePersist
    protected void onCreate() {
        if (this.date == null) {
            this.date = LocalDateTime.now();
        }
    }
}