package com.kamikase.web.posbackend.client;

import com.kamikase.web.posbackend.model.ApiDTO.EsporteResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "esporte", url = "http://localhost:8081/esporte/")
public interface EsporteClient {
    @GetMapping("{codigo}")
    EsporteResponseDTO consultaEsporte(@PathVariable("codigo") String codigo);
}
