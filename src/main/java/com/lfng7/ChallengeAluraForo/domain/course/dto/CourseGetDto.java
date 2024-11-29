package com.lfng7.ChallengeAluraForo.domain.course.dto;

import com.lfng7.ChallengeAluraForo.domain.course.CourseEntity;

public record CourseGetDto(
        Long id,
        String name,
        String category) {

    public CourseGetDto(CourseEntity course) {
        this(
                course.getId(),
                course.getName(),
                course.getCategory()
        );
    }
}
