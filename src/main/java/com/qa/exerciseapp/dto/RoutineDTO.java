package com.qa.exerciseapp.dto;

import java.util.ArrayList;
import java.util.List;

public class RoutineDTO {

    private Long routineId;
    private String routineName;
    private List<ExerciseInfoDTO> exerciseInfo = new ArrayList<>();

    public RoutineDTO(String routineName) {
        this.routineName = routineName;
    }

    public RoutineDTO() {
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

    public List<ExerciseInfoDTO> getExerciseInfo() {
        return exerciseInfo;
    }

    public void setExerciseInfo(List<ExerciseInfoDTO> exerciseInfo) {
        this.exerciseInfo = exerciseInfo;
    }
}
