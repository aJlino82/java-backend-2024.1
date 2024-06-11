package com.kamikase.web.posbackend.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class ClubeValidator implements
        ConstraintValidator<ClubeValidation, String> {
    private String message;

    @Override
    public void initialize(ClubeValidation constraintAnnotation) {
        message = constraintAnnotation.message();
    }


    @Override
    public boolean isValid(String nome, ConstraintValidatorContext constraintValidatorContext) {
        if (nome.contains("Vasco") || nome.contains("Botafogo") || nome.contains("Fluminense")) {
            return false;
        }
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext
                .buildConstraintViolationWithTemplate(message + nome)//
                .addConstraintViolation();
        return true;
    }

}
