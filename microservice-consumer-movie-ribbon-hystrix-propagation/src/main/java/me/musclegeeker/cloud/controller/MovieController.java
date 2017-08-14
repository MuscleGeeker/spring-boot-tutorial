package me.musclegeeker.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import me.musclegeeker.cloud.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    @HystrixCommand(fallbackMethod = "getByIdFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE")
    })
    public User getById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://microservice-provider-user/api/user/" + id, User.class);
    }

    private User getByIdFallback(Long id) {
        User user = new User();
        user.setId(-1L);
        return user;
    }
}
