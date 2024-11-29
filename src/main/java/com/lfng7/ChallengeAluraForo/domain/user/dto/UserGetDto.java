package com.lfng7.ChallengeAluraForo.domain.user.dto;

import com.lfng7.ChallengeAluraForo.domain.user.UserEntity;

public record UserGetDto(
        Long id,
        String name,
        String email,
        String createdAt
) {

    public UserGetDto(UserEntity user) {
        this(
                user.getId(),
                user.getname(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }
}
