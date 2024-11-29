package com.lfng7.ChallengeAluraForo.domain.answer;

import com.lfng7.ChallengeAluraForo.domain.topical.TopicalEntity;
import com.lfng7.ChallengeAluraForo.domain.user.UserEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "answers")
public class AnswerEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "message", nullable = false)
    private String message;

    @ManyToOne
    @JoinColumn(name="topical_id", nullable = false)
    private TopicalEntity topical;

    @Column(name = "created_at", nullable = false)
    private String createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "soluction")
    private int solution;

    public AnswerEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TopicalEntity getTopical() {
        return topical;
    }

    public void setTopical(TopicalEntity topical) {
        this.topical = topical;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public int getSolution() {
        return solution;
    }

    public void setSolution(int solution) {
        this.solution = solution;
    }
}

