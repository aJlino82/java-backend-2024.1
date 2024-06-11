package com.kamikase.web.posbackend.model.Clube;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kamikase.web.posbackend.validator.ClubeValidation;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.Date;

@Data
@Entity
public class Clube {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "O nome do clube deve ser informado")
    @ClubeValidation
    private String nome;
    @NotBlank(message = "O estado do clube deve ser informado")
    private String estado;
    @NotBlank(message = "O email do clube deve ser informado")
    @Email
    private String email;
    @NotBlank(message = "O CNPJ do clube deve ser informado")
    @CNPJ
    private String cnpj;
    @NotNull(message = "A data de fundação do clube deve ser informada")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataFundacao;

}
