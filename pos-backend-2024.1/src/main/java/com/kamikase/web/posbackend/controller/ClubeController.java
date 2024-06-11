package com.kamikase.web.posbackend.controller;

import com.kamikase.web.posbackend.client.CnpjClient;
import com.kamikase.web.posbackend.model.ApiDTO.CnpjResponseDTO;
import com.kamikase.web.posbackend.model.Clube.Clube;
import com.kamikase.web.posbackend.model.Clube.ClubeDto;
import com.kamikase.web.posbackend.service.ClubeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/clube")
public class ClubeController {

    private final ClubeService clubeService;

    private final CnpjClient cnpjClient;

    @PostMapping
    public ResponseEntity<Clube> cadastrar(@RequestBody ClubeDto clubeDto) {
        Clube clube = clubeService.criar(clubeDto);
        return ResponseEntity.ok(clube);
    }

    @PutMapping
    public ResponseEntity<Clube> alterar(Clube clube) {
        clube = clubeService.alterar(clube);
        return ResponseEntity.ok(clube);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        clubeService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Clube>> listarTodos() {
        return ResponseEntity.ok(clubeService.listar());
    }

    @GetMapping("{id}")
    public ResponseEntity<Clube> consultarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(clubeService.consultarPorId(id));
    }

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<CnpjResponseDTO> consultaCNPJ(@PathVariable String cnpj) {
        CnpjResponseDTO cnpjResponse = cnpjClient.consultaCnpj(cnpj);
        System.out.println(cnpjResponse);
        return ResponseEntity.ok(cnpjResponse);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Clube>> consultarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(clubeService.findByNomeOrderByNomeAsc(nome));
    }
}
