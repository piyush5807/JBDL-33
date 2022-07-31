package com.example.minor1.services;

import com.example.minor1.models.MyUser;
import com.example.minor1.models.Student;
import com.example.minor1.repositories.StudentRepository;
import com.example.minor1.request.StudentCreateRequest;
import com.example.minor1.request.UserCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    MyUserDetailsService userDetailsService;

    public void create(StudentCreateRequest studentCreateRequest){

        UserCreateRequest userCreateRequest = studentCreateRequest.toUser();
        MyUser myUser = userDetailsService.createUser(userCreateRequest);

        Student student = studentCreateRequest.to();
        student.setMyUser(myUser);
        studentRepository.save(student);
    }

    public Student findStudentByStudentId(int sId){
        return studentRepository
                .findById(sId).orElse(null);
    }

}
