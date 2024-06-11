package com.kamikase.web.posbackend.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class EsporteValidator implements
        ConstraintValidator<EsporteValidation, String> {
    private String message;

    @Override
    public void initialize(EsporteValidation constraintAnnotation) {
        message = constraintAnnotation.message();
    }


    @Override
    public boolean isValid(String nome, ConstraintValidatorContext constraintValidatorContext) {
        if (nome.contains("Futebol")) {
            return true;
        }
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext
                .buildConstraintViolationWithTemplate(message + nome)//
                .addConstraintViolation();
        return false;
    }

}
