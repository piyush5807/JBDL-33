package com.example.minor1.request;

import com.example.minor1.models.*;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCreateRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String contact;

    private String address;
    private String email;

    public Student to(){
        return Student.builder()
                .address(address)
                .contact(contact)
                .email(email)
                .name(name)
                .accountStatus(AccountStatus.ACTIVE)
                .build();
    }
}
