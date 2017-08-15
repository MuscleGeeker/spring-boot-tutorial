package me.musclegeeker.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FallbackFactoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(FallbackFactoryApplication.class, args);
    }
}
