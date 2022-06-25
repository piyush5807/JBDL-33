package com.example.demomysql.request;

import com.example.demomysql.model.Person;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreatePersonRequest {

    @NotBlank(message = "FirstName should not be empty")
    private String firstName; // should not be empty

    private String lastName; // can be empty

    @NotBlank(message = "Date of birth should not be empty")
    private String dob; // mandatory

    public Person to(){
        return Person.builder()
                .firstName(firstName)
                .lastName(lastName)
                .dob(dob)
                .build();
    }

}
