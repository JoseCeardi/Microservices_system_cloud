package com.example.ms_kardex.mappers;

import com.example.ms_kardex.dtos.GenericKardexRequestDTO;
import com.example.ms_kardex.dtos.KardexDTO;
import com.example.ms_kardex.entities.KardexEntity;

import java.util.List;
import java.util.stream.Collectors;

public class KardexMapper {

    // Convierte la petición entrante en una Entidad lista para guardar
    public static KardexEntity toEntity(GenericKardexRequestDTO dto) {
        if (dto == null) return null;

        KardexEntity entity = new KardexEntity();
        entity.setToolId(dto.getToolId());
        entity.setLoanId(dto.getLoanId());
        entity.setRutClient(dto.getRutClient());
        entity.setMovementType(dto.getMovementType());
        entity.setDescription(dto.getDescription());
        entity.setQuantity(dto.getQuantity() != null ? dto.getQuantity() : 0);
        entity.setUserResponsible(dto.getUserResponsible());
        entity.setConsecuencia(dto.getConsecuencia());
        // La fecha se asigna sola con el @PrePersist de la entidad

        return entity;
    }

    // Convierte la Entidad de la BD en un DTO para mostrar
    public static KardexDTO toDto(KardexEntity entity) {
        if (entity == null) return null;

        KardexDTO dto = new KardexDTO();
        dto.setId(entity.getId());
        dto.setToolId(entity.getToolId());
        dto.setLoanId(entity.getLoanId());
        dto.setRutClient(entity.getRutClient());
        dto.setMovementType(entity.getMovementType().name());
        dto.setDescription(entity.getDescription());
        dto.setQuantity(entity.getQuantity());
        dto.setUserResponsible(entity.getUserResponsible());
        dto.setDate(entity.getDate());
        dto.setConsecuencia(entity.getConsecuencia());

        return dto;
    }

    public static List<KardexDTO> toDtoList(List<KardexEntity> entities) {
        return entities.stream()
                .map(KardexMapper::toDto)
                .collect(Collectors.toList());
    }
}