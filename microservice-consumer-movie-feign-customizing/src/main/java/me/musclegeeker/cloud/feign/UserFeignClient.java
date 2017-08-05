package me.musclegeeker.cloud.feign;

import feign.Param;
import feign.RequestLine;
import me.musclegeeker.cloud.domain.User;
import me.musclegeeker.config.CustomFeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "microservice-provider-user", configuration = CustomFeignConfig.class)
public interface UserFeignClient {
    //@RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
    @RequestLine("GET /api/user/{id}")
    User findUserById(@Param("id") Long id);
}
