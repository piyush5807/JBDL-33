package com.example.minor1.repositories;

import com.example.minor1.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    /**
     * Native query
     * JPQL - Java persistence query language
     * Don't have to write the query ...
     */

    Author findByEmail(String email);

    // you have to find all the authors above the age of 30,
    // living in india and their name starting with A

    List<Author> findByAgeGreaterThanEqualAndCountryAndNameStartingWith
            (int age, String country, String prefix);

    // select * from author where age >= ?1 and country = ?2 and name like ?3% ;

    @Query(value = "select a from author a where a.email = ?1", nativeQuery = true)
    public Author getAuthorGivenEmailIdNativeQuery(String author_email); // peter@gmail.com

    @Query("select a from Author a where a.email = ?1")
    public Author getAuthorGivenEmailIdJPQL(String author_email); // peter@gmail.com

    // You need to find all the authors in india
    @Query(value = "select a from author a where a.land = ?1", nativeQuery = true)
    public List<Author> getAuthorsByCountry(String country);

    @Query(value = "select a from Author a where a.country = ?1")
    public List<Author> getAuthorsByCountryJPQL(String country);


}
