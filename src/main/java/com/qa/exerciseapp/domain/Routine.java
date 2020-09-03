package com.qa.exerciseapp.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "ExerciseInfo"})
public class Routine {

    @Id
    @GeneratedValue
    private Long routineId;

    @Column (nullable = false)
    private String routineName;

    @OneToMany(mappedBy = "Routine", fetch = FetchType.EAGER)
    private List<ExerciseInfo> exerciseInfo = new ArrayList<>();

    @ManyToOne(targetEntity = User.class)
    private User user;

    public Routine() {}

    public Routine(String routineName) {
        this.routineName = routineName;
    }

    public Long getId() { return routineId; }

    public void setId(Long routineId) {
        this.routineId = routineId;
    }

    public String getRoutineName() {
        return routineName;
    }

    public void setRoutineName(String routineName) {
        this.routineName = routineName;
    }

    /*public List<ExerciseInfo> getExerciseInfo() { return exerciseInfo; }

    public void setExerciseInfo(List<ExerciseInfo> exerciseInfo) {
        this.exerciseInfo = exerciseInfo;
    }
*/
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getRoutineId() {
        return routineId;
    }

    public void setRoutineId(Long routineId) {
        this.routineId = routineId;
    }

    public List<ExerciseInfo> getExerciseInfo() {
        return exerciseInfo;
    }

    public void setExerciseInfo(List<ExerciseInfo> exerciseInfo) {
        this.exerciseInfo = exerciseInfo;
    }
}

