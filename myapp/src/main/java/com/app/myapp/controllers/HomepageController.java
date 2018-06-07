package com.app.myapp.controllers;

import com.app.myapp.database.service.TaskService;
import com.app.myapp.database.service.UserService;
import com.app.myapp.models.Task;
import com.app.myapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomepageController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model){
        List<Task> tasks = taskService.findallTasks();
        User user = new User();
        user.setName("Wazzup");
        user.setEmail("mail@test.com");
        user.setPassword("1234");
        user.setTasks(tasks);
        model.addAttribute("user",user);
        return "index1";
    }

    @PostMapping("/")
    public String processForm(@Valid User user){
        user.getTasks().forEach(task->{
            task.setUser(user);
        });

        userService.createUser(user);
        return "index1";
    }
}
