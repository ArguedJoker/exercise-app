package com.qa.exerciseapp.domain;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    @Column (nullable = false)
    private String firstName;

    @Column (nullable = false)
    private String lastName;

    @Column (nullable = false)
    private Float weight;

    @Column (nullable = false)
    private Float height;

    @Column (nullable = false, unique = true)
    private String email;

    @Column (nullable = false, unique = true)
    private String password;

    @OneToMany(mappedBy = "exerciseInfoId", fetch = FetchType.EAGER)
    private List<ExerciseInfo> exerciseInfo = new ArrayList<>();

    @OneToMany(mappedBy = "routineId", fetch = FetchType.EAGER)
    private List<Routine> routine = new ArrayList<>();

    public User() {

    }

    public Long getId() {
        return userId;
    }

    public void setId(Long id) {this.userId = id;}

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
