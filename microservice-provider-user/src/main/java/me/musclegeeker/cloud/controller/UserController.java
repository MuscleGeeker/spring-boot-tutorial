package me.musclegeeker.cloud.controller;

import me.musclegeeker.cloud.domain.User;
import me.musclegeeker.cloud.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserRepository userRepository;

    @GetMapping("/simple/user/{id}")
    public User findUserById(@PathVariable Long id) {
        return userRepository.findOne(id);
    }
}