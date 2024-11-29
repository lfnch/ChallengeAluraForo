package com.lfng7.ChallengeAluraForo.domain.profile;

import com.lfng7.ChallengeAluraForo.domain.user.UserEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "profiles")
public class ProfileEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "profiles")
    private Set<UserEntity> users;

    public ProfileEntity(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }
}