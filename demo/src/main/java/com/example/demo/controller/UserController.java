package com.example.demo.controller;

import com.example.demo.dto.user.UserRequest;
import com.example.demo.dto.user.UserResponse;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user") // it's for all endpoints in the class: localhost:8080/product/...
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/id/")
    public UserResponse userResponse(@PathVariable Long id){
        return userService.getById(id);
    }

    @PostMapping("/add")
    public void addUser(@RequestBody UserRequest userRequest){
        userService.addUser(userRequest);
    }
    @GetMapping("/getAllUsers")
    public List<UserResponse> userResponses(){
        return userService.getAll();
    }
    @DeleteMapping("/delete/id")
    public void deleteById(@PathVariable Long id){
        userService.deleteById(id);
    }
    @PutMapping("/update/{id}")
    public void updateById(@PathVariable Long id, @RequestBody UserRequest userRequest){
        userService.updateById(id, userRequest);
    }

}
