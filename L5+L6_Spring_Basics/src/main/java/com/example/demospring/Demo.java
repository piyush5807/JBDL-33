package com.example.demospring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
@Scope("prototype")
public class Demo { // demo

    private static Logger logger = LoggerFactory.getLogger(Demo.class);

    public Demo() {
        logger.info("Creating demo object ... {}", this);
    }

    private int id; // 0
    private String name; // null

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
