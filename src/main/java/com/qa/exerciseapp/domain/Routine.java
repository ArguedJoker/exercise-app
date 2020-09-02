package com.qa.exerciseapp.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Routine {

    @Id
    @GeneratedValue
    private Long routineId;

    @Column (nullable = false, unique = true)
    private String routineName;

    @OneToMany(mappedBy = "exerciseInfoId", fetch = FetchType.EAGER)
    private List<ExerciseInfo> exerciseInfo = new ArrayList<>();

    @ManyToOne(targetEntity = User.class)
    private User user;

    public Routine() {}

    public Routine(String routineName, Long routineId) {
        this.routineName = routineName;
        this.routineId = routineId;
    }

    public Long getRoutineId() { return routineId; }

    public void setRoutineId(Long id) {
        this.routineId = id;
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

