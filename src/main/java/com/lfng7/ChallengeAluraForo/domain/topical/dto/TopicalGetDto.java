package com.lfng7.ChallengeAluraForo.domain.topical.dto;

import com.lfng7.ChallengeAluraForo.domain.course.dto.CourseGetDto;
import com.lfng7.ChallengeAluraForo.domain.topical.TopicalEntity;
import com.lfng7.ChallengeAluraForo.domain.user.dto.UserGetDto;

public record TopicalGetDto(
        Long id,
        String title,
        String message,
        String createdAt,
        String state,
        UserGetDto user,
        CourseGetDto course
) {
    public TopicalGetDto(TopicalEntity topical) {
        this(
                topical.getId(),
                topical.getTitle(),
                topical.getMessage(),
                topical.getCreatedAt(),
                "sin estado",
                new UserGetDto(topical.getUser()),
                new CourseGetDto(topical.getCourse())
        );
    }
}
