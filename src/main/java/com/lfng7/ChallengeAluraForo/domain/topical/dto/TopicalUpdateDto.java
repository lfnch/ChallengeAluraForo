package com.lfng7.ChallengeAluraForo.domain.topical.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@NotNull
public record TopicalUpdateDto(

        @NotNull
        Long id,

        @NotBlank
        String title,

        @NotBlank
        String message,

        @NotBlank
        String state
) {

}
