package com.app.myapp.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String date;

    private String startTime;
    
    private String endTime;
    @NotEmpty
    private String description;

    @ManyToOne
    @JoinColumn(name = "USER_EMAIL")
    private User user;

    public Task() {
    }
    public Task(String date, String startTime, String endTime, User user) {

        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.user = user;
    }

    public Task(String date, String startTime, String endTime, String description) {

        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
