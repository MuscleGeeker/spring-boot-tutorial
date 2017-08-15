package me.musclegeeker.cloud.controller;

import me.musclegeeker.cloud.domain.User;
import me.musclegeeker.cloud.feign.EurekaFeignClient;
import me.musclegeeker.cloud.feign.UserFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Resource
    private UserFeignClient userFeignClient;

    @Resource
    private EurekaFeignClient eurekaFeignClient;

    @GetMapping("/user/{id}")
    public User getById(@PathVariable Long id) {
        return this.userFeignClient.findById(id);
    }

    @GetMapping("/service-info/{serviceName}")
    public String instanceInfo(@PathVariable String serviceName) {
        return this.eurekaFeignClient.findByServiceName(serviceName);
    }
}
