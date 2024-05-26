package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.entities.Cinema;
import com.example.demo.entities.Gestionnaire;
import com.example.demo.entities.Login;
import com.example.demo.entities.SuperAdmin;
import com.example.demo.repository.CinemaRepository;
import com.example.demo.repository.GestionnaireRepository;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class CinemaManagementApplication {

 

	public static void main(String[] args) {

		SpringApplication.run(CinemaManagementApplication.class, args);
	}
	  @Autowired
	    private GestionnaireRepository gr;

	
	
}


