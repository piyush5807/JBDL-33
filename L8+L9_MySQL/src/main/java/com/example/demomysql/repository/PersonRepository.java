package com.example.demomysql.repository;

import com.example.demomysql.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {

    private static Logger logger = LoggerFactory.getLogger(PersonRepository.class);

    private PreparedStatement createStatement;

    private Connection connection;

    /**
     * Insert / Update / Delete - ExecuteUpdate
     * Select - ExecuteQuery
     */

    // JDBC : Protocol which is used from Java application to relational db
    // JDBCTemplate : Dependency which allows you to map your java object to
    // db relation just like hibernate
    // RowMapper -

    PersonRepository(Connection connection) throws SQLException {
        this.connection = connection;
        createTable();
        this.createStatement = connection.prepareStatement(
                "insert into person (first_name, last_name, age, dob) " +
                        "VALUES (?, ?, ?, ?)");
    }

    public void createPerson(Person p){

        // DB operations
        // 1. DB Connection

        try {
            // Mapping our java class to the table columns

            createStatement.setString(1, p.getFirstName());
            createStatement.setString(2, p.getLastName());
            createStatement.setInt(3, p.getAge());
            createStatement.setString(4, p.getDob());
//            createStatement.setInt(1, p.getId());

            int result = createStatement.executeUpdate();

            logger.info("Insert statement result - {}", result >= 1 ? true : false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void createPersonStatic(Person p){

        // DB operations
        // 1. DB Connection

        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate("insert into person (id, first_name, last_name, age, dob) " +
                    "VALUES(1, 'ABC', 'DEF', 20, '01-01-2002')");

            logger.info("Insert statement result - {}", result >= 1 ? true : false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // select * from person;
    }
    // Static queries

    private void createTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("create table if not exists person (id int primary key auto_increment , first_name varchar(30), " +
                "last_name varchar(30), age int, dob varchar (12))");
    }

    public List<Person> getPeople() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from person");

            List<Person> personList = new ArrayList<>();
            while (resultSet.next()){
                Person person = getPersonFromResultSet(resultSet);

                personList.add(person);
            }
            return personList;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public Person getPersonById(int pId){
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("select * from person where id = ?");

            statement.setInt(1, pId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){

                return getPersonFromResultSet(resultSet);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    // Mapping our db to the java class
    // Hibernate : ORM - Object relation mapping
    private Person getPersonFromResultSet(ResultSet resultSet) throws SQLException {
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        int id = resultSet.getInt("id");
        int age = resultSet.getInt(4);
        String dob = resultSet.getString(5);

        return Person.builder()
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .id(id)
                .dob(dob)
                .build();
    }

    public boolean delete(int pId) {
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("delete from person where id = ?");

            statement.setInt(1, pId);

            int result = statement.executeUpdate();
            logger.info("Insert statement result - {}", result >= 1 ? true : false);
            return result >= 1 ? true : false;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }
}
