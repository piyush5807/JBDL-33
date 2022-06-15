package com.example.demospring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Configuration
@Scope("prototype")
public class DemoConfig {

    private static Logger logger = LoggerFactory.getLogger(DemoConfig.class);

    @Bean
    public RestTemplate getTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        logger.info("Inside getTemplate.. {}", restTemplate);
        return restTemplate;
    }

    @Bean
    public RestTemplate getTemplate2(){
        RestTemplate restTemplate = new RestTemplate();
        logger.info("Inside getTemplate2.. {}", restTemplate);
        return restTemplate;
    }

    @Bean("bcrypt")
    @Scope("prototype")
    public PasswordEncoder getPE(){
        logger.info("Creating Bcrypt PE.. ");
        return new BCryptPasswordEncoder();
    }

    @Bean("noop")
    public PasswordEncoder getPE2(){
        return NoOpPasswordEncoder.getInstance();
    }
}
