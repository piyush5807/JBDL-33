package com.example.demomysql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DBConfig {

    @Bean
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/jbdl33_person", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
