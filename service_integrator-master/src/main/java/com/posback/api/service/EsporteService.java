package com.posback.api.service;

import com.posback.api.model.Esporte;
import com.posback.api.repository.EsporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsporteService {

    @Autowired
    EsporteRepository repository;

    public Esporte salvar(Esporte esporte) {
        return repository.save(esporte);
    }

    public Esporte findEsporteByCode(String codigoDisciplina) {
        return repository.findByCodigo(codigoDisciplina);
    }

    public List<String> listarCodigoEsportes() {
        return repository.listarCodigoDisciplina();
    }

    public List<Esporte> listarEsportes() {
        return repository.findAll();
    }

    public Esporte listaPorNome(String nome) {
        return repository.findByNome(nome);
    }

}
