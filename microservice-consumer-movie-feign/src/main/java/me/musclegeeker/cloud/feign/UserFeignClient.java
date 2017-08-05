package me.musclegeeker.cloud.feign;

import me.musclegeeker.cloud.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("microservice-provider-user")
public interface UserFeignClient {

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
    User findUserById(@PathVariable("id") Long id);

    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    User postUser(@RequestBody User user);
}
