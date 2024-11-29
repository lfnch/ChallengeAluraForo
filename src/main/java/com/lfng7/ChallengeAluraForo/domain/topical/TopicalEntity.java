package com.lfng7.ChallengeAluraForo.domain.topical;

import com.lfng7.ChallengeAluraForo.domain.course.CourseEntity;
import com.lfng7.ChallengeAluraForo.domain.topical.dto.TopicalCreateDto;
import com.lfng7.ChallengeAluraForo.domain.topical.dto.TopicalUpdateDto;
import com.lfng7.ChallengeAluraForo.domain.user.UserEntity;
import com.lfng7.ChallengeAluraForo.util.CurrentDate;
import jakarta.persistence.*;

@Entity
@Table(name = "topicals")
public class TopicalEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name="message", nullable = false)
    private String message;

    @Column(name = "created_at", nullable = false)
    private String createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private CourseEntity course;

    @Column(name = "answers")
    private int answers;

    public TopicalEntity() {
    }

    public TopicalEntity(TopicalCreateDto topicalDto) {
        this.title = topicalDto.title();
        this.message = topicalDto.message();
        this.createdAt = CurrentDate.getCurrentDate();
        this.user = new UserEntity(topicalDto.userId());
        this.course = new CourseEntity(topicalDto.courseId());
        this.answers = 0;
    }

    public void updateTopical(TopicalUpdateDto topicalDto) {
        this.title = topicalDto.title();
        this.message = topicalDto.message();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public int getAnswers() {
        return answers;
    }

    public void setAnswers(int answers) {
        this.answers = answers;
    }
}
