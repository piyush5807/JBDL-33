package com.example.minor1.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    // yml, yaml
    // jpg, jpeg
    // htm, html

    @Value("${custom.my_prop}")
    String sample_text;

    @GetMapping("/sample")
    public String getSampleText(){
        return this.sample_text;
    }
}
