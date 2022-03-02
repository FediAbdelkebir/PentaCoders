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
		String url = "jdbc:mysql://localhost:3306/Workmood?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "root";
		String password = "";
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
        senderService.sendEmail("oussema.jebari@esprit.tn", "The subject", "The body of Email");
	}
}
