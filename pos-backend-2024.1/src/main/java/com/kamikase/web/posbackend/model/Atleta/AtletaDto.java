package com.kamikase.web.posbackend.model.Atleta;

public record AtletaDto(String nome,
                        Integer anoNascimento,
                        String esporte,
                        String email,
                        String cpf
) {
}