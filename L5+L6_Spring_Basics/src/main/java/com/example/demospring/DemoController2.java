package com.example.demospring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/v2")
public class DemoController2 {

    @Autowired
    Demo demo;

//    @Autowired
//    DemoController demoController;

    @Autowired
    DemoConfig demoConfig;

    @Autowired
    @Qualifier("getTemplate")
    @Primary
    RestTemplate restTemplate;

//    @Autowired
//    @Qualifier("bcrypt")
//    PasswordEncoder passwordEncoder;

    // synchronized         --> critical section
    // application context  --> ioc container

    private static Logger logger = LoggerFactory.getLogger(DemoController2.class);

    @GetMapping("/sample")
//    @ResponseBody
    public Demo getDemo(){
//        logger.info("demoController - {}, demo of dc1 - {}, demo of dc2 - {}", demoController, demoController.demo, demo);
//        logger.info("a = {}", a);
//        Demo demo = new Demo();
//        logger.info("demo object in sample API - {}", demo);
        return demo;
    }

    @GetMapping("/getTemplate")
    public String getTemplate(){
        logger.info("restTemplate - {}", restTemplate);
        return "Sample string!!!";
    }


    @GetMapping("/encode")
    public String getEncodedPwd(@RequestParam("rawPwd") String rawPwd){
        logger.info("Bcrypt encoder - {}", demoConfig.getPE());
        return demoConfig.getPE().encode(rawPwd);
    }
}

// org.springframework.web.client.RestTemplate@530a8454 - R1
// org.springframework.web.client.RestTemplate@d71adc2 - R2


// org.springframework.web.client.RestTemplate@d71adc2 - getTemplate2
// org.springframework.web.client.RestTemplate@530a8454 -  getTemplate