package com.example.ms_customers.mappers;

import com.example.ms_customers.dtos.CustomerDTO;
import com.example.ms_customers.entities.CustomerEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    // Constructor privado para evitar que alguien instancie esta clase (clase de utilidad)
    private CustomerMapper() {}

    public static CustomerDTO toDto(CustomerEntity entity) {
        if (entity == null) return null;

        CustomerDTO dto = new CustomerDTO();
        dto.setRut(entity.getRut());
        dto.setNombre(entity.getNombre());
        dto.setTelefono(entity.getTelefono());
        dto.setCorreo(entity.getCorreo());
        dto.setActive(entity.getActive());
        return dto;
    }

    public static CustomerEntity toEntity(CustomerDTO dto) {
        if (dto == null) return null;

        CustomerEntity entity = new CustomerEntity();
        entity.setRut(dto.getRut());
        entity.setNombre(dto.getNombre());
        entity.setTelefono(dto.getTelefono());
        entity.setCorreo(dto.getCorreo());
        entity.setActive(dto.getActive());
        return entity;
    }

    public static List<CustomerDTO> toDtoList(List<CustomerEntity> entities) {
        if (entities == null) return List.of();
        return entities.stream()
                .map(CustomerMapper::toDto)
                .collect(Collectors.toList());
    }
}