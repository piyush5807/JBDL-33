package com.example.demomysql.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Person {

    private Integer id;  // automatically generated by server |  FE need not send this
    private String firstName;
    private String lastName;
    private Integer age;
    private String dob;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public Person(int id, String firstName, String lastName, int age) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//    }
//
//    public Person() {
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", age=" + age +
//                '}';
//    }
}