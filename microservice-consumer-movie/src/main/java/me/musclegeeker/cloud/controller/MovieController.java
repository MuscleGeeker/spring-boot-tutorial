package me.musclegeeker.cloud.controller;

import me.musclegeeker.cloud.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class MovieController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/movie/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://localhost:7900/simple/user/" + id, User.class);
    }
}
