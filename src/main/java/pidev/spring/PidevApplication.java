package pidev.spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import pidev.spring.entities.EmailSenderService;

@SpringBootApplication
public class PidevApplication {
	
	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {
		String url = "jdbc:mysql://udugso46lqiotqrx:HBN5SyT3RpkT8bfgCuqd@bmjq0fwqtaqyt7smb7k7-mysql.services.clever-cloud.com:3306/bmjq0fwqtaqyt7smb7k7";
		String username = "udugso46lqiotqrx";
		String password = "HBN5SyT3RpkT8bfgCuqd";

		System.out.println("Connecting database...");

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		    System.out.println("Database connected!");
		    
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
		SpringApplication.run(PidevApplication.class, args);
		
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail(){
		senderService.sendEmail("asma.besbes@esprit.tn", "The subject", "The body of Email");
	}

}
