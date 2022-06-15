package com.example.demospring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController   // dc1 -> id1,  dc2 -> id2
//@Scope("prototype")
// Dispatcher servlet searches for @Controller mapping classes
@RequestMapping("/v1")
public class DemoController {

    @Autowired
    @Qualifier("bcrypt")
    PasswordEncoder passwordEncoder;

    @GetMapping("/encode")
    public String getEncodedPwd(@RequestParam("rawPwd") String rawPwd){
        logger.info("Bcrypt encoder - {}", passwordEncoder);
        return passwordEncoder.encode(rawPwd);
    }


    // Bean - Object which is created by spring
    // Bean - Something which will create / know during the application startup

//    @Autowired  // This annotation picks the reference of class Demo's bean from the IOC container
    Demo demo; // null o1

    private static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    public DemoController(Demo demo){
        this.demo = demo;
        logger.info("Creating object ... {}", this);
    }

//    @Value("${server.port}")
//    private Integer a;

//    public DemoController(@Value("${custom_prop}") String a){
//        logger.info("a = {}", a);
//
//    }


    @GetMapping("/sample")
//    @ResponseBody
    public Demo getDemo(){
//        logger.info("a = {}", a);
//        Demo demo = new Demo();
        logger.info("demo object in sample API - {}", demo);
        return demo;
    }

    @PostMapping("/post_sample")
    public Demo postDemo(){
//        Demo demo = new Demo();
        logger.info("demo object in sample API - {}", demo);
        return demo;
    }

    /*
            {
                "id": 0,
                "name": null
            },

            "hello demo!"
     */


    // com.example.demospring.Demo@64db48f4
    // com.example.demospring.Demo@64db48f4
    // com.example.demospring.Demo@64db48f4

    // 1. Inversion of Control - IOC
    // 2. Dependency Injection -


    // 1. Field injection
    // 2. Constructor Injection
}
