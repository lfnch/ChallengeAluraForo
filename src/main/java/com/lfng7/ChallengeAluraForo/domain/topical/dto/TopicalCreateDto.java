package com.lfng7.ChallengeAluraForo.domain.topical.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicalCreateDto(

        @NotBlank
        String title,

        @NotBlank
        String message,

        @NotNull
        @Min(value = 1)
        Long userId,

        @NotNull
        @Min(value = 1)
        Long courseId
) {
}
