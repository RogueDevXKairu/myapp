package com.app.myapp.models;

import java.util.ArrayList;
import java.util.List;

public class TaskWrapper {
    private List<Task> taskwraps;

    public TaskWrapper() {
        this.taskwraps = new ArrayList<>();
    }

    public List<Task> getTaskwraps() {
        return taskwraps;
    }

    public void setTaskwraps(List<Task> taskwraps) {
        this.taskwraps.addAll(taskwraps);
    }
}
