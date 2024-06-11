package com.kamikase.web.posbackend.repository;

import com.kamikase.web.posbackend.model.Clube.Clube;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubeRepository extends JpaRepository<Clube, Integer> {

    public List<Clube> findByNomeContainingIgnoreCaseOrderByNomeAsc(String nome);
}