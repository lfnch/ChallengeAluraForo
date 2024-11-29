package com.lfng7.ChallengeAluraForo.infra.error;

import org.springframework.validation.FieldError;

public record ErrorValidationDto(String field, String error) {
    public ErrorValidationDto(FieldError fieldError) {
        this(
                fieldError.getField(),
                fieldError.getDefaultMessage()
        );
    }
}