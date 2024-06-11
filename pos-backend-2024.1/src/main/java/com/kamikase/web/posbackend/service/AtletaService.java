package com.kamikase.web.posbackend.service;

import com.kamikase.web.posbackend.model.Atleta.Atleta;
import com.kamikase.web.posbackend.model.Atleta.AtletaDto;
import com.kamikase.web.posbackend.repository.AtletaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class AtletaService {

    private final AtletaRepository repository;

    public Atleta cadastrar(AtletaDto atletaDto) {
        Atleta atleta = new Atleta();
        atleta.setNome(atletaDto.nome());
        atleta.setEsporte(atletaDto.esporte());
        atleta.setEmail(atletaDto.email());
        atleta.setCpf(atletaDto.cpf());
        atleta.setAnoNascimento(atletaDto.anoNascimento());
        return repository.save(atleta);
    }

    public List<Atleta> listar() {
        return repository.findAll();
    }

    public List<Atleta> listarPorNome(String nome) {
        return repository.findByNomeOrderByNomeAsc(nome);
    }

    public Atleta alterar(Atleta atleta) {
        if (Objects.isNull(atleta.getId())) {
            throw new RuntimeException();
        }
        return repository.save(atleta);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }

    public Atleta consultarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

}
