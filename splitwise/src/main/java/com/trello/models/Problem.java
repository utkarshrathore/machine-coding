package com.trello.models;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Problem {
    private final String id;
    private String name;
    private List<Task> tasks;
    private String boardId;

    public Problem(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.tasks = new LinkedList<Task>();
        this.boardId = null;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", tasks=" + tasks +
                ", boardId=" + boardId +
                '}';
    }
}