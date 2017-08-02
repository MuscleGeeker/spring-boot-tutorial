package me.musclegeeker.cloud;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import me.musclegeeker.cloud.annotation.ExcludeFromComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExcludeFromComponentScan
public class RibbonConfig {

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
