package com.example.ms_kardex.enums;

public enum KardexMovementType {
    // Eventos de Cliente
    CUSTOMER_CREATE,
    CUSTOMER_BAN,
    CUSTOMER_RELEASE,
    CUSTOMER_UPDATE,

    // Eventos de Herramientas (Futuro)
    TOOL_CREATE,
    TOOL_DAMAGE,
    TOOL_REPAIR,
    TOOL_RETIRE,

    // Eventos de Préstamos (Futuro)
    LOAN_START,
    LOAN_RETURN
}