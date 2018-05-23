package com.app.myapp.database.repository;

import com.app.myapp.models.Task;
import com.app.myapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByUser(User user);
}
