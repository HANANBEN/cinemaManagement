package web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import web.Entities.Cinema;
import web.Entities.Gestionnaire;
import web.Entities.Login;
import web.Entities.SuperAdmin;
import web.Repositories.CinemaRepository;
import web.Repositories.GestionnaireRepository;

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


