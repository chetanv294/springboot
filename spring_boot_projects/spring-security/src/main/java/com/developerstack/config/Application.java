package com.developerstack.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

// com.chetan.users.model,
@ComponentScan(basePackages = "com.developerstack,com.springboot.services.model,"
		+ "com.chetan.users.service")
@SpringBootApplication
public class Application extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}