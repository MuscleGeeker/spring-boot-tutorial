package me.musclegeeker.cloud.fallback;

import feign.hystrix.FallbackFactory;
import me.musclegeeker.cloud.domain.User;
import me.musclegeeker.cloud.feign.UserFeignClient;
import me.musclegeeker.cloud.feign.UserFeignClientWithFallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
    @Override
    public UserFeignClient create(Throwable throwable) {
        return (UserFeignClientWithFallbackFactory) id -> {
            User user = new User();
            user.setId(-1L);
            return user;
        };
    }
}
