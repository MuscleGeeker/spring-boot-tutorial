package me.musclegeeker.cloud.controller;

import me.musclegeeker.cloud.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/user-list")
    public List<User> getUserList() {
        User[] users = this.restTemplate.getForObject("http://microservice-provider-user/api/user/list", User[].class);
        return Arrays.asList(users);
    }
}
