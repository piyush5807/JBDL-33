package com.example.demojpa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {

    @Id
    private int id;

    @Column(unique = true)
    private String name;

    private int age;
}
