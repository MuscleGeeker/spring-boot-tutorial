package me.musclegeeker.cloud.feign;

import config.EurekaFeignConfig;
import me.musclegeeker.cloud.fallback.EurekaFeignFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        name = "eureka-feign-client",
        url = "http://localhost:8761",
        configuration = EurekaFeignConfig.class,
        fallback = EurekaFeignFallback.class
)
public interface EurekaFeignClient {

    @RequestMapping(value = "/eureka/apps/{serviceName}", method = RequestMethod.GET)
    String findByServiceName(@PathVariable("serviceName") String serviceName);
}
