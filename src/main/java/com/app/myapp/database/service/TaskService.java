package com.app.myapp.database.service;

import com.app.myapp.database.repository.TaskRepository;
import com.app.myapp.models.Task;
import com.app.myapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public void addTask(Task task, User user){
        task.setUser(user);
        taskRepository.save(task);
    }

    public List<Task> findTasksByUser(User user){
        return taskRepository.findByUser(user);
    }
}
