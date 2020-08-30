package com.qa.exerciseapp.domain;

import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ExerciseInfo {

    @Id
    @GeneratedValue
    private Long exerciseInfoId;

    @Column
    @NonNull
    private String exerciseTitle;

    @Column
    private String exerciseDescription;

    @Column
    private int exerciseDuration;

    @Column
    @NonNull
    private String targetMuscle;

    @Column
    private int numberOfSets;

    @Column
    private int numberOfReps;

    public Long getId() {
        return exerciseInfoId;
    }

    public ExerciseInfo() {

    }

    public ExerciseInfo(Long exerciseInfoId, String exerciseTitle, String exerciseDescription, int exerciseDuration, String targetMuscle, int numberOfSets, int numberOfReps) {
        this.exerciseInfoId = exerciseInfoId;
        this.exerciseTitle = exerciseTitle;
        this.exerciseDescription = exerciseDescription;
        this.exerciseDuration = exerciseDuration;
        this.targetMuscle = targetMuscle;
        this.numberOfSets = numberOfSets;
        this.numberOfReps = numberOfReps;
    }

    public void setId(Long id) { this.exerciseInfoId = id; }

    public String getTargetMuscle() {
        return targetMuscle;
    }

    public void setTargetMuscle(String targetMuscle) {
        this.targetMuscle = targetMuscle;
    }

    public String getExerciseTitle() {
        return exerciseTitle;
    }

    public void setExerciseTitle(String activityTitle) {
        this.exerciseTitle = activityTitle;
    }

    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public void setExerciseDescription(String activityDescription) {
        this.exerciseDescription = activityDescription;
    }

    public int getExerciseDuration() {
        return exerciseDuration;
    }

    public void setExerciseDuration(int activityDuration) {
        this.exerciseDuration = activityDuration;
    }

    public int getNumberOfReps() {
        return numberOfReps;
    }

    public void setNumberOfReps(int numberOfReps) {
        this.numberOfReps = numberOfReps;
    }

    public int getNumberOfSets() {
        return numberOfSets;
    }

    public void setNumberOfSets(int numberOfSets) {
        this.numberOfSets = numberOfSets;
    }

}


