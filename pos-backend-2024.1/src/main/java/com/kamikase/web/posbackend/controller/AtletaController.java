package com.kamikase.web.posbackend.controller;

import com.kamikase.web.posbackend.client.ViaCepClient;
import com.kamikase.web.posbackend.model.Atleta.Atleta;
import com.kamikase.web.posbackend.model.Atleta.AtletaDto;
import com.kamikase.web.posbackend.model.ApiDTO.CepResponseDTO;
import com.kamikase.web.posbackend.service.AtletaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/atleta")
public class AtletaController {

    private final AtletaService service;

    private final ViaCepClient viaCepClient;

    @PostMapping
    public ResponseEntity<Atleta> cadastrar(@RequestBody AtletaDto atletaDto) {
        Atleta atleta = service.cadastrar(atletaDto);
        return ResponseEntity.ok(atleta);
    }

    @PutMapping
    public ResponseEntity<Atleta> alterar(@RequestBody Atleta atleta) {
        atleta = service.alterar(atleta);
        return ResponseEntity.ok(atleta);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Atleta> consultarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.consultarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Atleta>> listarTodos() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Atleta>> listarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(service.listarPorNome(nome));
    }


    @GetMapping("/cep/{cep}")
    public ResponseEntity<CepResponseDTO> consultarCepAtleta(@PathVariable String cep) {
        CepResponseDTO cepResponse = viaCepClient.consultaCep(cep);
        return ResponseEntity.ok(cepResponse);
    }

}
