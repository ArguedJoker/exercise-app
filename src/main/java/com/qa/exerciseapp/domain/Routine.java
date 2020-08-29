package com.qa.exerciseapp.domain;

import javax.persistence.*;

@Entity
public class Routine {

    @Id
    private String routineName;

    @Column
    private Long userId;

    @Column
    private Long exerciseInfoId;


public Routine() {}

    public Routine(String routineName, Long userId, Long exerciseInfoId) {
        this.routineName = routineName;
        this. userId = userId;
        this. exerciseInfoId = exerciseInfoId;
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
}

