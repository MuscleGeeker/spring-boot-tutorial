package me.musclegeeker.cloud.feign;

import me.musclegeeker.cloud.domain.User;
import me.musclegeeker.cloud.fallback.UserFeignClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "microservice-provider-user", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);
}
