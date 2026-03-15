package com.example.ms_kardex.services;

import com.example.ms_kardex.dtos.GenericKardexRequestDTO;
import com.example.ms_kardex.dtos.KardexDTO;
import com.example.ms_kardex.entities.KardexEntity;
import com.example.ms_kardex.mappers.KardexMapper;
import com.example.ms_kardex.repositories.KardexRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class KardexService {

    private final KardexRepository kardexRepository;

    public KardexDTO registrarEventoGenerico(GenericKardexRequestDTO request) {
        // Mapeamos a entidad y guardamos
        KardexEntity entityToSave = KardexMapper.toEntity(request);
        KardexEntity savedEntity = kardexRepository.save(entityToSave);

        // Retornamos el DTO del registro recién creado
        return KardexMapper.toDto(savedEntity);
    }

    public List<KardexDTO> getAllRegistros() {
        List<KardexEntity> entidades = kardexRepository.findAll();
        return KardexMapper.toDtoList(entidades);
    }
}