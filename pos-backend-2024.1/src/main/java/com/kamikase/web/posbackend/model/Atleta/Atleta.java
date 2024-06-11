package com.kamikase.web.posbackend.model.Atleta;

import com.kamikase.web.posbackend.validator.EmailValidation;
import com.kamikase.web.posbackend.validator.EsporteValidation;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

@Data
@Entity
public class Atleta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 150)
    @NotEmpty(message = "O campo não pode estar em branco ou nulo")
    private String nome;

    @NotNull
    private Integer anoNascimento;

    @EsporteValidation
    @NotEmpty(message = "O campo não pode estar em branco ou nulo")
    private String esporte;

    @Email
    @EmailValidation
    @NotBlank(message = "O campo não pode estar em branco ou nulo")
    private String email;

    @CPF
    @NotBlank(message = "O campo não pode estar em branco ou nulo")
    private String cpf;

}
