package com.qa.exerciseapp.dto;

import com.qa.exerciseapp.domain.Routine;
import com.qa.exerciseapp.domain.User;

public class ExerciseInfoDTO {

    private Long exerciseInfoId;
    private String exerciseTitle;
    private String exerciseDescription;
    private int exerciseDuration;
    private String targetMuscle;
    private int numberOfSets;
    private int numberOfReps;
    private User user;
    private Routine routine;

    public ExerciseInfoDTO() {

    }

    public Long getExerciseInfoId() {
        return exerciseInfoId;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }
}
