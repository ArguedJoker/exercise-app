package com.qa.exerciseapp.dto;

public class RoutineDTO {

    private Long routineId;
    private String routineName;
    private Long userId;
    private Long exerciseInfoId;

    public RoutineDTO() {

    }

    public RoutineDTO(String routineName, Long userId, Long exerciseInfoId) {
        this.routineName = routineName;
        this.userId = userId;
        this.exerciseInfoId = exerciseInfoId;
    }

    public Long getRoutineId() {
        return routineId;
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
