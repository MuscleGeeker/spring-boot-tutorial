package me.musclegeeker.cloud.feign;

import config.UserFeignConfig;
import feign.Param;
import feign.RequestLine;
import me.musclegeeker.cloud.domain.User;
import me.musclegeeker.cloud.fallback.UserFeignFallback;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(
        name = "microservice-provider-user",
        configuration = UserFeignConfig.class,
        fallback = UserFeignFallback.class
)
public interface UserFeignClient {

    //    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
    @RequestLine(value = "GET /api/user/{id}")
    User findById(@Param("id") Long id);

}
