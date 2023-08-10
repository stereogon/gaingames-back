package com.fitnessapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringFitnessAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFitnessAppApplication.class, args);
	}

}
