package me.musclegeeker.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomFeignConfig {

    @Bean
    public Contract contract() {
        return new feign.Contract.Default();
    }
}
