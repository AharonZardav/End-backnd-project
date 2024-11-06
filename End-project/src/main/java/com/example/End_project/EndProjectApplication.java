package com.example.End_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EndProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EndProjectApplication.class, args);
	}
}