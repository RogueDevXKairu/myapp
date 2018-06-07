package com.app.myapp.database.service;

import com.app.myapp.database.repository.UserRepository;
import com.app.myapp.models.Role;
import com.app.myapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(User user){
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void createAdmin(User user){
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        Role role = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);

    }

    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
