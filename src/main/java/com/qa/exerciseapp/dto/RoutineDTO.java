package com.qa.exerciseapp.dto;

import com.qa.exerciseapp.domain.ExerciseInfo;
import com.qa.exerciseapp.domain.User;

import java.util.ArrayList;
import java.util.List;

public class RoutineDTO {

    private Long routineId;
    private String routineName;
   // private List<ExerciseInfo> exerciseInfo = new ArrayList<>();
   // private User user;

    public RoutineDTO(Long routineId, String routineName) {

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

}
