package com.example.minor1;

import com.example.minor1.models.Admin;
import com.example.minor1.models.Author;
import com.example.minor1.models.Book;
import com.example.minor1.models.MyUser;
import com.example.minor1.repositories.AdminRepository;
import com.example.minor1.repositories.AuthorRepository;
import com.example.minor1.repositories.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class Minor1Application implements CommandLineRunner {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	MyUserRepository myUserRepository;

	@Autowired
	AdminRepository adminRepository;


	public static void main(String[] args) {
		SpringApplication.run(Minor1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("In run function of main class");
//
//		MyUser myUser = MyUser.builder()
//				.username("raj")
//				.password(passwordEncoder.encode("raj123"))
//				.authority("adm")
//				.build();
//
//		myUser = myUserRepository.save(myUser);
//
//		Admin admin = Admin.builder()
//				.age(40)
//				.name("Raj Shukla")
//				.myUser(myUser)
//				.build();
//
//		adminRepository.save(admin);
	}
}
