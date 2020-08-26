package com.qa.exerciseapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pumpit {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String activityTitle;

    @Column
    private String activityDescription;

    @Column
    private int activityDuration;

    @Column
    private int numberOfReps;

    public Long getId() {
        return id;
    }

    public Pumpit() {

    }

    public Pumpit(String activityTitle, String activityDescription, int activityDuration, int numberOfReps) {
        this.activityTitle = activityTitle;
        this.activityDescription = activityDescription;
        this.activityDuration = activityDuration;
        this.numberOfReps = numberOfReps;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public int getActivityDuration() {
        return activityDuration;
    }

    public void setActivityDuration(int activityDuration) {
        this.activityDuration = activityDuration;
    }

    public int getNumberOfReps() {
        return numberOfReps;
    }

    public void setNumberOfReps(int numberOfReps) {
        this.numberOfReps = numberOfReps;
    }
}


