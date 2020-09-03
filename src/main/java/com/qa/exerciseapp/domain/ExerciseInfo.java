package com.qa.exerciseapp.domain;
import javax.persistence.*;

@Entity
public class ExerciseInfo {

    @Id
    @GeneratedValue
    private Long exerciseInfoId;

    @Column (nullable = false)
    private String exerciseTitle;

    @Column
    private String exerciseDescription;

    @Column
    private int exerciseDuration;

    @Column (nullable = false)
    private String targetMuscle;

    @Column
    private int numberOfSets;

    @Column
    private int numberOfReps;

    @ManyToOne(targetEntity = Routine.class)
    private Routine routine;

    public ExerciseInfo() {}

    public ExerciseInfo(String exerciseTitle, String exerciseDescription, int exerciseDuration, String targetMuscle, int numberOfSets, int numberOfReps) {
        this.exerciseTitle = exerciseTitle;
        this.exerciseDescription = exerciseDescription;
        this.exerciseDuration = exerciseDuration;
        this.targetMuscle = targetMuscle;
        this.numberOfSets = numberOfSets;
        this.numberOfReps = numberOfReps;
    }

    public void setId(Long id) { this.exerciseInfoId = id; }

    public String getExerciseTitle() {
        return exerciseTitle;
    }

    public void setExerciseTitle(String exerciseTitle) {
        this.exerciseTitle = exerciseTitle;
    }

    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public void setExerciseDescription(String exerciseDescription) {
        this.exerciseDescription = exerciseDescription;
    }

    public int getExerciseDuration() {
        return exerciseDuration;
    }

    public void setExerciseDuration(int exerciseDuration) {
        this.exerciseDuration = exerciseDuration;
    }

    public String getTargetMuscle() {
        return targetMuscle;
    }

    public void setTargetMuscle(String targetMuscle) {
        this.targetMuscle = targetMuscle;
    }

    public int getNumberOfSets() {
        return numberOfSets;
    }

    public void setNumberOfSets(int numberOfSets) {
        this.numberOfSets = numberOfSets;
    }

    public int getNumberOfReps() {
        return numberOfReps;
    }

    public void setNumberOfReps(int numberOfReps) {
        this.numberOfReps = numberOfReps;
    }

    public Long getExerciseInfoId() {
        return exerciseInfoId;
    }

    public void setExerciseInfoId(Long exerciseInfoId) {
        this.exerciseInfoId = exerciseInfoId;
    }

    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }
}


