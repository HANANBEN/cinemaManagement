<<<<<<<< HEAD:CinemaManagementApplication.java
========
package Controller;

>>>>>>>> 245228b840a969c905c9191087904f9bddf22396:src/main/java/Controller/CinemaManagementApplication.java

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class CinemaManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(CinemaManagementApplication.class, args);
	}

}
