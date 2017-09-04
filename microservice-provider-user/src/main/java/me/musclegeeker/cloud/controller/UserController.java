package me.musclegeeker.cloud.controller;

import com.google.common.collect.Lists;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import me.musclegeeker.cloud.domain.User;
import me.musclegeeker.cloud.repository.UserRepository;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserRepository userRepository;

    @Resource
    private EurekaClient eurekaClient;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable Long id) {
        return userRepository.findOne(id);
    }

    @PostMapping("/user")
    public User postUser(@RequestBody User user) {
        return user;
    }

    @GetMapping("/eureka-instance")
    public String serviceUrl() {
        InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
        return instance.getHomePageUrl();
    }

    @GetMapping("/instance-info")
    public ServiceInstance instanceInfo() {
        return this.discoveryClient.getLocalServiceInstance();
    }

    @GetMapping("/user/list")
    public List<User> getUserList() {
        ArrayList<User> list = Lists.newArrayList();

        list.add(userRepository.findOne(1L));
        list.add(userRepository.findOne(2L));
        list.add(userRepository.findOne(3L));

        return list;
    }
}