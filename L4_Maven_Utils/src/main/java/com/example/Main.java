package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {

        int a = 10 / 2;
        int b = 20 / 4;
        int c = 60 / 6;

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy_db", "root", "");

        Statement statement = connection.createStatement();
        statement.execute("create table jbdl_33(id int auto_increment, name varchar(30))");
    }
}
