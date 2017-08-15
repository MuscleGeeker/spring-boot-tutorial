package me.musclegeeker.cloud.feign;

import me.musclegeeker.cloud.domain.User;
import me.musclegeeker.cloud.fallback.FeignClientFallbackFactory;
import me.musclegeeker.config.UserFeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        name = "microservice-provider-user",
        configuration = UserFeignConfig.class,
        fallbackFactory = FeignClientFallbackFactory.class
)
public interface UserFeignClient {

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);
}
