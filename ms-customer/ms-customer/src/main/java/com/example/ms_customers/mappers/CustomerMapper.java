package com.example.ms_customers.mappers;

import com.example.ms_customers.dtos.CustomerDTO;
import com.example.ms_customers.entities.CustomerEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    public static CustomerEntity toEntity(CustomerDTO dto) {
        if (dto == null) return null;
        CustomerEntity entity = new CustomerEntity();
        entity.setRut(dto.getRut());
        entity.setNombre(dto.getNombre());
        entity.setCorreo(dto.getCorreo());
        entity.setTelefono(dto.getTelefono());
        entity.setActive(dto.getActive() != null ? dto.getActive() : true);
        return entity;
    }

    public static CustomerDTO toDto(CustomerEntity entity) {
        if (entity == null) return null;
        return new CustomerDTO(
                entity.getRut(),
                entity.getNombre(),
                entity.getTelefono(),
                entity.getCorreo(),
                entity.getActive()
        );
    }

    public static List<CustomerDTO> toDtoList(List<CustomerEntity> entities) {
        return entities.stream()
                .map(CustomerMapper::toDto)
                .collect(Collectors.toList());
    }
}