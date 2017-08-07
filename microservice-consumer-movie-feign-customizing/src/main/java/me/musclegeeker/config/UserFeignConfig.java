package me.musclegeeker.config;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserFeignConfig {

    @Bean
    public Contract contract() {
        return new feign.Contract.Default();
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
