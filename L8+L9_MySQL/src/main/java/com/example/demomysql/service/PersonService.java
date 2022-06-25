package com.example.demomysql.service;

import com.example.demomysql.model.Person;
import com.example.demomysql.repository.PersonRepository;
import com.example.demomysql.request.CreatePersonRequest;
import com.example.demomysql.utils.BadPersonRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

    public Person getPerson(int id){
        return personRepository.getPersonById(id);
    }

    private Integer calculateAgeFromDOB(String dob){
        if(dob == null){
            return null;
        }

        LocalDate dobDate = LocalDate.parse(dob);
        LocalDate currentDate = LocalDate.now();

        return Period.between(dobDate, currentDate).getYears();
    }

    public List<Person> getPeople() {
        return personRepository.getPeople();
    }

    public Person deletePerson(int pId) throws Exception {
        Person person = personRepository.getPersonById(pId);
        boolean isDeleted = personRepository.delete(pId);
        if(isDeleted){
            return person;
        }

        throw new BadPersonRequestException("Person id " + pId + " is not present in db");
    }
}
