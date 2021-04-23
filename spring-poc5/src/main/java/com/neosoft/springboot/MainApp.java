package com.neosoft.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootApplication
public class MainApp {
	 
    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
       log.info("Springboot with Thymeleaf application is started successfully.");
    }
}
