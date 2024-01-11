/*
package com.example.demo.controller;


import com.example.demo.dto.user.UserRequest;
import com.example.demo.dto.user.UserResponse;
import com.example.demo.entites.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class MainController {

    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/hello")
    public String name(@RequestParam String name){

        return name+" hello!";
    }
    @GetMapping("/allUsers")
    List<User> users(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public UserResponse userResponse(@PathVariable Long id){
        return userService.getById(id);
    }
    @PostMapping("/register")
    public void register(@RequestBody UserRequest userRequest){
        userService.register(userRequest);
    }
    @GetMapping("/login")
    public boolean login(@RequestParam String username, int password){
        //
        System.out.println("Entered data: " + username + " " + password);
        return(true);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        User deleteUser = userRepository.getById(id);
        userService.delete(deleteUser);
        return "Delete user with the id: " +id;
    }
    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable Long id ,@RequestBody User user){
        Optional<User> updateUser = userRepository.findById(id);
        if (updateUser.isEmpty())
            throw new BadRequestException("badee");
        updateUser.get().setName(user.getName());
        updateUser.get().setCourse(user.getCourse());
        updateUser.get().setAge(user.getAge());
        userRepository.save(updateUser.get());
        return "Updated..";
    }
}




*/
