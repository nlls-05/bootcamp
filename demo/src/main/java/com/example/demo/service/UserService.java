package com.example.demo.service;

import com.example.demo.dto.user.UserRequest;
import com.example.demo.dto.user.UserResponse;
import com.example.demo.entites.User;

import java.util.List;

public interface UserService {
  /*  String findAll(String name);*/

    UserResponse getById(Long id);

    /*void register(UserRequest userRequest);*/

    /*void delete(User deleteUser);*/

    void addUser(UserRequest userRequest);

    List<UserResponse> getAll();

    void deleteById(Long id);

    void updateById(Long id, UserRequest userRequest);
}