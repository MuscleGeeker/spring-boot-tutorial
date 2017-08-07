package me.musclegeeker.cloud.feign;

import feign.Param;
import feign.RequestLine;
import me.musclegeeker.cloud.domain.User;
import me.musclegeeker.config.UserFeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "microservice-provider-user", configuration = UserFeignConfig.class)
public interface UserFeignClient {
    @RequestLine("GET /api/user/{id}")
    User findUserById(@Param("id") Long id);
}
