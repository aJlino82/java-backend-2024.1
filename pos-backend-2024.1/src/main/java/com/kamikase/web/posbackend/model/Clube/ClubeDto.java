package com.kamikase.web.posbackend.model.Clube;

import java.util.Date;

public record ClubeDto(String nome,
                       String estado,
                       String email,
                       String cnpj,
                       Date dataFundacao
) {
}