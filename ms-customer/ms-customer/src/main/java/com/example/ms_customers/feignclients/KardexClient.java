package com.example.ms_customers.feignclients;

import com.example.ms_customers.dtos.GenericKardexRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-kardex")
public interface KardexClient {

    @PostMapping("/api/kardex/eventos")
    void registrarEvento(@RequestBody GenericKardexRequestDTO request);
}