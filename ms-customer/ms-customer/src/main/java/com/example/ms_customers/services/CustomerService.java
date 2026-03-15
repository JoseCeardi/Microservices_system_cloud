package com.example.ms_customers.services;

import com.example.ms_customers.dtos.CustomerDTO;
import com.example.ms_customers.dtos.GenericKardexRequestDTO;
import com.example.ms_customers.entities.CustomerEntity;
import com.example.ms_customers.enums.KardexMovementType;
import com.example.ms_customers.feignclients.KardexClient;
import com.example.ms_customers.mappers.CustomerMapper;
import com.example.ms_customers.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final KardexClient kardexClient;

    public CustomerDTO createCustomer(CustomerDTO dto) {
        //  Mapear y guardar en base de datos local
        CustomerEntity entity = CustomerMapper.toEntity(dto);
        CustomerEntity savedEntity = customerRepository.save(entity);

        //  Construir el paquete genérico para Kardex
        GenericKardexRequestDTO eventoAuditoria = new GenericKardexRequestDTO();
        eventoAuditoria.setRutClient(savedEntity.getRut()); // Enviamos el RUT como identificador principal
        eventoAuditoria.setMovementType(KardexMovementType.CUSTOMER_CREATE); // Enum correcto
        eventoAuditoria.setDescription("Creación de nuevo cliente: " + savedEntity.getNombre() + " (" + savedEntity.getCorreo() + ")");
        eventoAuditoria.setQuantity(0); // No aplica a stock
        eventoAuditoria.setUserResponsible("SYSTEM_CUSTOMER"); // Idealmente aquí iría el usuario logueado en el futuro

        try {
            kardexClient.registrarEvento(eventoAuditoria);
            System.out.println("Auditoría enviada a Kardex con éxito.");
        } catch (Exception e) {
            System.err.println("Advertencia: Falló la comunicación con Kardex. " + e.getMessage());
        }

        return CustomerMapper.toDto(savedEntity);
    }

    public List<CustomerDTO> getAllCustomers() {
        return CustomerMapper.toDtoList(customerRepository.findAll());
    }
}