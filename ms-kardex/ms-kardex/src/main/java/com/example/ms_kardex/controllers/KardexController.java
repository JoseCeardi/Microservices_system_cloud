package com.example.ms_kardex.controllers;

import com.example.ms_kardex.dtos.GenericKardexRequestDTO;
import com.example.ms_kardex.dtos.KardexDTO;
import com.example.ms_kardex.services.KardexService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kardex")
@AllArgsConstructor
public class KardexController {

    private final KardexService kardexService;

    // El endpoint universal para recibir eventos
    @PostMapping("/eventos")
    public ResponseEntity<KardexDTO> registrarEvento(@RequestBody GenericKardexRequestDTO request) {
        KardexDTO nuevoRegistro = kardexService.registrarEventoGenerico(request);
        return new ResponseEntity<>(nuevoRegistro, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<KardexDTO>> findAll() {
        List<KardexDTO> registros = kardexService.getAllRegistros();
        if (registros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(registros);
    }
}