package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Cinema;
import com.example.demo.repository.CinemaRepository;



@SpringBootApplication
public class CinemaManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaManagementApplication.class, args);
	}
   
}