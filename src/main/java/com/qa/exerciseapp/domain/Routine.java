package com.qa.exerciseapp.domain;

import javax.persistence.*;

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


public Routine() {}

    public Routine(Long routineId, String routineName, Long userId, Long exerciseInfoId) {
        this.routineId = routineId;
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


}

