package com.example.minor1;

import com.example.minor1.models.Author;
import com.example.minor1.models.Book;
import com.example.minor1.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class Minor1Application implements CommandLineRunner {

	@Autowired
	AuthorRepository authorRepository;

	public static void main(String[] args) {
		SpringApplication.run(Minor1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("In run function of main class");
		List<Author> authorList =  authorRepository
				.findByAgeGreaterThanEqualAndCountryAndNameStartingWith(30, "India", "P");

//		authorList.stream()
//				.map(author -> author.getBookList())
//				.forEach(books -> System.out.println(books.size()));

		authorList.forEach(System.out::println);
	}
}
