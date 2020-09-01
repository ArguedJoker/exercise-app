package com.qa.exerciseapp.domain;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    @Column
    @NonNull
    private String firstName;

    @Column
    @NonNull
    private String lastName;

    @Column
    @Nullable
    private Float weight;

    @Column
    @Nullable
    private Float height;

    @Column
    @NonNull
    private String email;

    @Column
    @NonNull
    private String password;

    public Long getUserId() {
        return userId;
    }

    public User() {

    }

    public User(Long userId, String firstName, String lastName, Float weight, Float height, String email, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.weight = weight;
        this.height = height;
        this.email = email;
        this.password = password;
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
}
