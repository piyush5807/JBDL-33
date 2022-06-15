package com.example.demospring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DemoSpringApplication {

	private static Logger logger = LoggerFactory.getLogger(DemoSpringApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringApplication.class, args);
		logger.info("My application is started");

		OtherClassImpl otherClass = new OtherClassImpl();
		logger.info("Result of 2 + 3 = {}", otherClass.add(2, 3));

//		DemoController demoController = new DemoController(); // not be stored in the container

//		logger.info("demoController object is {}", demoController);
	}

	// com.example.demospring.DemoController@3fc08eec - created by spring
	// com.example.demospring.DemoController@6de30571 - created by me in the main class

}
