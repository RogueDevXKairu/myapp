package com.app.myapp.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User {
    @Id
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(min = 6)
    private String password;
    @NotEmpty
    private String name;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Task> tasks;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_EMAIL",referencedColumnName = "email")
    },inverseJoinColumns = {
            @JoinColumn(name = "ROLE_NAME", referencedColumnName = "name")
    })
    private List<Role> roles;

    public User() {}

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
