package com.example.demomysql.controller;

import com.example.demomysql.model.Person;
import com.example.demomysql.request.CreatePersonRequest;
import com.example.demomysql.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
//@ControllerAdvice
public class PersonController {

    @Autowired
    PersonService personService;

    private static Logger logger = LoggerFactory.getLogger(PersonController.class);

//    @PostMapping("/person")
//    public void createPerson(@RequestBody Person person){
//
//    }

//    @PostMapping("/person")
//    public ResponseEntity createPerson(@RequestBody @Valid CreatePersonRequest personRequest){
//
//        // Logging the request
//        logger.info("person - {}", personRequest);
//
//        // Applying validations
////        if(personRequest.getFirstName() == null || personRequest.getFirstName().isEmpty()){
////            logger.info("Person's first name is empty");
////            return;
////        }
////
////        if(personRequest.getDob() == null || personRequest.getDob().isEmpty()){
////            logger.info("Person's dob is empty");
////            return;
////        }
//
//        Integer a = new Random().nextInt() % 2;
//        if(a == 0){
//            logger.info("Random no % 2 is 0");
//            throw new IndexOutOfBoundsException();
//        }
//
//        logger.info("Going to save the request in db...");
//
//        // Logic for saving the request in db
//
//        MultiValueMap<String, String> headers = new HttpHeaders();
//        headers.add("sample_header", "Person type object");
//
//        return new ResponseEntity(new Person(), headers, HttpStatus.CREATED);
////        return new ResponseEntity(new Person(), HttpStatus.CREATED);
//    }
//

    @PostMapping("/person")
    public void createPerson(@Valid @RequestBody CreatePersonRequest createPersonRequest){

        // Validations and Exception handling we have outsourced
        // Invoking service class' function
        personService.createPerson(createPersonRequest);
    }


//    public static void main(String[] args) {
//
////        People people = new People();
////        people.setAge();
//
//        People.PeopleBuilder personBuilder = People.builder();
//        personBuilder.firstName("ABC").lastName("XYZ");
//
//        People people = setFn(personBuilder);
//
//        int personAge = calculateAge();
//        people.setAge(personAge);
//
//    }
//
//    public static People setFn(People.PeopleBuilder personBuilder){
//        // logic to calculate age
//        int age = 10;
//        return personBuilder.age(age).build();
//    }
//
//    // Return the age of a person
//    public static int calculateAge(){
//        return 10;
//    }
}
