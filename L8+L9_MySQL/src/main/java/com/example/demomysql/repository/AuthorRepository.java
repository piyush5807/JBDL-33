package com.example.demomysql.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;

@Repository
public class AuthorRepository {

    @Autowired
    Connection connection;
}
