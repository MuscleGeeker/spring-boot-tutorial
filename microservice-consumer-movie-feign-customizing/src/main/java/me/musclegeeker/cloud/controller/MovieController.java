package me.musclegeeker.cloud.controller;

import me.musclegeeker.cloud.domain.User;
import me.musclegeeker.cloud.feign.UserFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MovieController {

    @Resource
    private UserFeignClient userFeignClient;

    @GetMapping("/api/movie/user/{id}")
    public User getUserById(@PathVariable Long id) {
        System.out.println("================调用获取user api=================");
        return userFeignClient.findUserById(id);
    }
}
