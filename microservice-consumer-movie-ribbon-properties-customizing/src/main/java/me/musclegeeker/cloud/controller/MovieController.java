package me.musclegeeker.cloud.controller;

import me.musclegeeker.cloud.domain.User;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class MovieController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/movie/user/{id}")
    public User getUserById(@PathVariable Long id) {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        System.out.println("---->" + serviceInstance.getHost() + ":" + serviceInstance.getPort());

        return this.restTemplate.getForObject("http://microservice-provider-user/simple/user/" + id, User.class);
    }

    @GetMapping("/instance-info")
    public void instanceInfo() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        System.out.println("1---->" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "\t" + "+");
        System.out.println("===================================================");
        ServiceInstance serviceInstance1 = this.loadBalancerClient.choose("microservice-provider-user1");
        System.out.println("2---->" + serviceInstance1.getHost() + ":" + serviceInstance1.getPort() + "\t" + "-");
    }
}
