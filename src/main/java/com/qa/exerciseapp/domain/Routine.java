package com.qa.exerciseapp.domain;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Routine {

    @Id
    @GeneratedValue
    private Long routineId;

    @Column (nullable = false)
    private String routineName;

  /*  @OneToMany(mappedBy = "exerciseInfoId", fetch = FetchType.EAGER)
    private List<ExerciseInfo> exerciseInfo = new ArrayList<>();

    @ManyToOne(targetEntity = User.class)
    private User user;
*/
    public Routine() {}

    public Long getRoutineId() { return routineId; }

    public void setRoutineId(Long routineId) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/
}

