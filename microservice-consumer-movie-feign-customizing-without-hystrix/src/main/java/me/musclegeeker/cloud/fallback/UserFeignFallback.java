package me.musclegeeker.cloud.fallback;

import me.musclegeeker.cloud.domain.User;
import me.musclegeeker.cloud.feign.UserFeignClient;
import org.springframework.stereotype.Component;

@Component
public class UserFeignFallback implements UserFeignClient {
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        return user;
    }
}
