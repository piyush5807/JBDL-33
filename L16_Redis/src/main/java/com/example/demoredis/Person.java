package com.example.demoredis;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person implements Serializable {

    private long id;
    private String name;
    private int age;
    private double creditScore;
}
