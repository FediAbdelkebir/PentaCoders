package pidev.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PidevApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PidevApplication.class, args);
		
	}

}
