package me.musclegeeker.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserFeignConfig {

    @Bean
    public Logger.Level logger() {
        return Logger.Level.FULL;
    }
}
