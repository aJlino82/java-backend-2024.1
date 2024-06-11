package com.posback.api.repository;

import com.posback.api.model.Esporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EsporteRepository extends JpaRepository<Esporte, Long> {
    Esporte findByCodigo(String codigo);

    @Query("select d.codigo from Esporte d")
    List<String> listarCodigoDisciplina();

    Esporte findByNome(String nome);

}
