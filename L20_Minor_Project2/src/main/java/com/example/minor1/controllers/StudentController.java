package com.example.minor1.controllers;

import com.example.minor1.models.MyUser;
import com.example.minor1.models.Student;
import com.example.minor1.request.BookCreateRequest;
import com.example.minor1.request.StudentCreateRequest;
import com.example.minor1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public void createStudent(@Valid @RequestBody StudentCreateRequest studentCreateRequest){
        studentService.create(studentCreateRequest);
    }

    // Only for students
    @GetMapping("/student")
    public Student getStudent() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUser myUser = (MyUser) authentication.getPrincipal();
        if(myUser.getStudent() == null){
            throw new Exception("User requesting the details is not a student");
        }
        int studentId = myUser.getStudent().getId();
        return studentService.findStudentByStudentId(studentId);
    }

    // Only for admins
    @GetMapping("/student_for_admin")
    public Student getStudentForAdmin(@RequestParam("studentId") int studentId) throws Exception {
        // check the person accessing this API is an admin or not
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUser myUser = (MyUser) authentication.getPrincipal();
        if(myUser.getAdmin() == null){
            throw new Exception("User requesting the details is not an admin");
        }

        return studentService.findStudentByStudentId(studentId);
    }
}
