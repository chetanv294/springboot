package com.springboot.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.springboot.services,com.springboot.custom.exception,com.springboot.services.model")
@SpringBootApplication
public class SpringBootRestApplication {

	public static void main(String[] args) {
		System.out.println("Spring Boot Init");
		SpringApplication.run(SpringBootRestApplication.class, args);
		System.out.println("Spring Boot Started...");
	}
}