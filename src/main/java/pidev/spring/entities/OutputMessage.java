package pidev.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Data
@AllArgsConstructor
public class OutputMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String from;
	private String text;
	private String time;
}
