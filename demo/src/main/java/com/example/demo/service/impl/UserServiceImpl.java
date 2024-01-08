package com.example.demo.service.impl;

import com.example.demo.entites.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserRepository userRepository;
    @Override
    public String findAll(String name) {
        User user = new User();
        user.setName(name);

        userRepository.save(user);
        return name+" registered!";
    }

    @Override
    public User register(String name, Integer age, String course) {
        User user = new User();
        user.setCourse(course);
        user.setName(name);
        user.setAge(age);
        userRepository.save(user);

        return user;
    }

    public Integer findAll(Integer age){
        User user = new User();
        user.setAge(age);
        userRepository.save(user);
        return age;

    }
}