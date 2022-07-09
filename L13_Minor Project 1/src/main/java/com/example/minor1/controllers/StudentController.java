package com.example.minor1.controllers;

import com.example.minor1.request.BookCreateRequest;
import com.example.minor1.request.StudentCreateRequest;
import com.example.minor1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public void createStudent(@Valid @RequestBody StudentCreateRequest studentCreateRequest){
        studentService.create(studentCreateRequest);
    }
}
