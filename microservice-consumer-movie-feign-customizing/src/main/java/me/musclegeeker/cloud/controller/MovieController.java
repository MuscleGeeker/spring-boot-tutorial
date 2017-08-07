package me.musclegeeker.cloud.controller;

import com.netflix.appinfo.InstanceInfo;
import me.musclegeeker.cloud.domain.User;
import me.musclegeeker.cloud.feign.EurekaFeignClient;
import me.musclegeeker.cloud.feign.UserFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MovieController {

    @Resource
    private UserFeignClient userFeignClient;

    @Resource
    private EurekaFeignClient eurekaFeignClient;

    @GetMapping("/api/movie/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userFeignClient.findUserById(id);
    }

    @GetMapping("/api/eurekaClientInfo/{serviceName}")
    public String getEurekaInfo(@PathVariable String serviceName) {
        return eurekaFeignClient.findSvcFromEurekaBySvcName(serviceName);
    }
}
