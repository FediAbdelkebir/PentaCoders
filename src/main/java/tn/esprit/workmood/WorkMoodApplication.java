package tn.esprit.workmood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication//(exclude = { SecurityAutoConfiguration.class })
public class WorkMoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkMoodApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*@Bean
	public SpringApplicationContext springApplicationContext() {
		return new SpringApplicationContext();
	}*/

}
