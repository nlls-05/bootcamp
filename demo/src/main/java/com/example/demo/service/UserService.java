package com.example.demo.service;

import com.example.demo.entites.User;

public interface UserService {
    String findAll(String name);

    User register(String name, Integer age, String course);
}