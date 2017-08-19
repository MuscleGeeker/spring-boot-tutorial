package me.musclegeeker.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class PathTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(PathTurbineApplication.class, args);
    }
}
