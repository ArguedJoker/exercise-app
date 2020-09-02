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

    public List<ExerciseInfo> getExerciseInfo() { return exerciseInfo; }

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

