package com.app.myapp;

import com.app.myapp.database.service.TaskService;
import com.app.myapp.database.service.UserService;
import com.app.myapp.models.Task;
import com.app.myapp.models.User;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyappApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    @Before
    public void initialDB(){

        User user = new User("user@mail.com","pass123","user");
        userService.createUser(user);

        User user2 = new User("user2@mail.com","pass123","user2");
        userService.createUser(user2);

        Task task = new Task("09/08/2012","00:11","11:00","New task");
        taskService.addTask(task,user);
    }

    @Test
    public void instantiateUser(){
        User user = new User("test@mail.com","pass123","test");
        Assertions.assertThat(user).isNotNull();
    }

    @Test
    public void findUser(){
        User user = new User("find@mail.com","pass123","test");
        userService.createUser(user);
        Assertions.assertThat(userService.findUserByEmail("find@mail.com").getName())
        .isEqualTo("test");
    }

    @Test
    public void findTaskOfUser(){
        User user = new User("user@mail.com","pass123","user");
        List<Task> taskofuser = taskService.findTasksByUser(user);
        Task task = new Task("09/08/2012","00:11","11:00","New task");
        Assertions.assertThat(taskofuser).extracting("description").contains("New task");
    }
}
