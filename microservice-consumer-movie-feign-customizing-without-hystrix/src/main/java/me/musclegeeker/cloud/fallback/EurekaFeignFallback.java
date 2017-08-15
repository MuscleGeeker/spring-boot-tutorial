package me.musclegeeker.cloud.fallback;

import me.musclegeeker.cloud.feign.EurekaFeignClient;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EurekaFeignFallback implements EurekaFeignClient {
    @Override
    public String findByServiceName(String serviceName) {
        return "Service invalid";
    }
}
