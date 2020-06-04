package com.trello.models;

import java.util.UUID;

public class Task {
    private final String id;
    private String name;
    private String description;
    private String assignedUser;
    private String problemId;

    public Task(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = null;
        this.assignedUser = null;
        this.problemId = null;
    }

    public Task(String name, String description) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.assignedUser = null;
        this.problemId = null;
    }

    public Task(String name, String description, String assignedUser) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.assignedUser = assignedUser;
        this.problemId = null;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    public String getProblemId() {
        return problemId;
    }

    public void setProblemId(String problemId) {
        this.problemId = problemId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", assignedUser='" + assignedUser + '\'' +
                ", problemId='" + problemId + '\'' +
                '}';
    }
}