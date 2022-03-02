package tn.esprit.workmood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class WorkMoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkMoodApplication.class, args);
	}

}
