package com.qa.exerciseapp.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Routine {

    @Id
    @GeneratedValue
    private Long routineId;

    @Column
    private String routineName;

    @Column
    private Long userId;

    @Column
    private Long exerciseInfoId;

    public Long getRoutineId() {
        return routineId;
    }

    @OneToMany(mappedBy = "ExerciseInfo", fetch = FetchType.LAZY)
    private List<ExerciseInfo> exerciseInfo = new ArrayList<>();

    @ManyToOne(targetEntity = User.class)
    private User user;

public Routine() {}

    public Routine(String routineName, Long userId, Long exerciseInfoId) {

        this.routineName = routineName;
        this.userId = userId;
        this.exerciseInfoId = exerciseInfoId;
    }

    public void setRoutineId(Long routineId) {
        this.routineId = routineId;
    }

    public String getRoutineName() {
        return routineName;
    }

    public void setRoutineName(String routineName) {
        this.routineName = routineName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getExerciseInfoId() {
        return exerciseInfoId;
    }

    public void setExerciseInfoId(Long exerciseInfoId) {
        this.exerciseInfoId = exerciseInfoId;
    }

    public List<ExerciseInfo> getExerciseInfo() {
        return exerciseInfo;
    }

    public void setExerciseInfo(List<ExerciseInfo> exerciseInfo) {
        this.exerciseInfo = exerciseInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

