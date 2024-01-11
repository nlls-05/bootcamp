package com.example.demo.service.impl;

import com.example.demo.dto.user.UserRequest;
import com.example.demo.dto.user.UserResponse;
import com.example.demo.entites.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
/*    @Override
    public String findAll(String name) {
        User user = new User();
        user.setName(name);

        userRepository.save(user);
        return name+" registered!";
    }*/

/*    @Override
    public UserResponse getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            System.out.println("user is empty!");
        }
        else {
            UserResponse userResponse = new UserResponse();
            userResponse.setId(user.get().getId());
            userResponse.setAge(user.get().getAge());
            userResponse.setName(user.get().getName());
            return userResponse;

        }
        return null;
    }*/

   /* @Override
    public void register(UserRequest userRequest) {
        User user = new User();
        user.setAge(userRequest.getAge());
        user.setName(userRequest.getName());
        user.setCourse(userRequest.getCourse());

        userRepository.save(user);
    }*/

  /*  @Override
    public void delete(User deleteUser) {
        userRepository.delete(deleteUser);
    }
*/

    public UserResponse getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new NotFoundException("user with id: "+id+" not found!", HttpStatus.BAD_GATEWAY);
        return userMapper.toDto(user.get());
    }
    @Override
    public void addUser(UserRequest userRequest) {
        User user = new User();
        user.setId(userRequest.getId());
        user.setName(userRequest.getName());
        user.setAge(userRequest.getAge());
        user.setCourse(userRequest.getCourse());
        userRepository.save(user);
    }

    @Override
    public List<UserResponse> getAll() {
        return userMapper.toDtoS(userRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        if (userRepository.findById(id).isEmpty())
            throw new NotFoundException("the user with id: "+id+" is empty!", HttpStatus.BAD_REQUEST);
        userRepository.deleteById(id);

    }

    @Override
    public void updateById(Long id, UserRequest userRequest) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new NotFoundException("the user with id: "+id+" is empty!", HttpStatus.BAD_REQUEST);
        user.get().setName(userRequest.getName());
        user.get().setAge(userRequest.getAge());
        user.get().setCourse(userRequest.getCourse());
        userRepository.save(user.get());
    }
}