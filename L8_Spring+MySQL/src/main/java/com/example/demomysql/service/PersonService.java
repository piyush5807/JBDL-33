package com.example.demomysql.service;

import com.example.demomysql.model.Person;
import com.example.demomysql.repository.PersonRepository;
import com.example.demomysql.request.CreatePersonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public void createPerson(CreatePersonRequest createPersonRequest){

        Person person = createPersonRequest.to();
        if(person.getAge() == null){
            Integer age = calculateAgeFromDOB(person.getDob());
            person.setAge(age);
        }

        personRepository.createPerson(person);
    }

    private Integer calculateAgeFromDOB(String dob){
        if(dob == null){
            return null;
        }

        LocalDate dobDate = LocalDate.parse(dob);
        LocalDate currentDate = LocalDate.now();

        return Period.between(dobDate, currentDate).getYears();
    }
}
