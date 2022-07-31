package com.example.minor1.request;

import com.example.minor1.models.Admin;
import com.example.minor1.models.Student;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateRequest {

    private String username;

    private String password;

    private String authority;

    private Student student;

    private Admin admin;
}
