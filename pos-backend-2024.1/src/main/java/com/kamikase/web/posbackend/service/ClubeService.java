package com.kamikase.web.posbackend.service;

import com.kamikase.web.posbackend.model.Clube.Clube;
import com.kamikase.web.posbackend.model.Clube.ClubeDto;
import com.kamikase.web.posbackend.repository.ClubeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ClubeService {

    private final ClubeRepository repository;

    public List<Clube> listar() {
        return repository.findAll();
    }

    public Clube consultarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public Clube criar(ClubeDto clubeDto) {
        Clube clube = new Clube();
        clube.setNome(clubeDto.nome());
        clube.setEstado(clubeDto.estado());
        clube.setEmail(clubeDto.email());
        clube.setCnpj(clubeDto.cnpj());
        clube.setDataFundacao(clubeDto.dataFundacao());
        return repository.save(clube);
    }

    public Clube alterar(Clube clube) {
        if (Objects.isNull(clube.getId())) {
            throw new RuntimeException();
        }
        return repository.save(clube);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }

    public List<Clube> findByNomeOrderByNomeAsc(String nome) {
        return repository.findByNomeContainingIgnoreCaseOrderByNomeAsc(nome);
    }
}

