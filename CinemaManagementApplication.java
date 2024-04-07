<<<<<<<< HEAD:src/main/java/Controller/CinemaManagementApplication.java
package Controller;

========
>>>>>>>> b52e1aeaf12189c98ac3bee3d1dcfafcec03ba3c:CinemaManagementApplication.java

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
