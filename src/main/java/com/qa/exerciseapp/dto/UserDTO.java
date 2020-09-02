package com.qa.exerciseapp.dto;

import com.qa.exerciseapp.domain.ExerciseInfo;
import com.qa.exerciseapp.domain.Routine;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private Float weight;
    private Float height;
    private String email;
    private String password;
    private List<ExerciseInfo> exerciseInfo = new ArrayList<>();
    private List<Routine> routine = new ArrayList<>();


    public UserDTO() {

    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ExerciseInfo> getExerciseInfo() {
        return exerciseInfo;
    }

    public void setExerciseInfo(List<ExerciseInfo> exerciseInfo) {
        this.exerciseInfo = exerciseInfo;
    }

    public List<Routine> getRoutine() {
        return routine;
    }

    public void setRoutine(List<Routine> routine) {
        this.routine = routine;
    }
}
