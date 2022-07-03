package com.example.demojpa.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "my_person")
public class Person {

    /**
     * Hibernate converts all the camel cases into two words separated by underscore
     * Hibernate convert all the upercases into lowercase
     */
    private static int counter;

    // myFirstName --> my_first_name

    @Id
    private Integer id;  // automatically generated by server |  FE need not send this

    @Column(name = "first_name", length = 30)
    private String firstName;
    private String lastName;

    private Integer age;
    private String dob;

    @Transient
    private String countryCode;
}