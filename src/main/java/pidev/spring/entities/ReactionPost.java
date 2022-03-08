package pidev.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity 
@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
@ToString 
@EqualsAndHashCode 

public class ReactionPost implements Serializable {
   
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id; 	

	@ManyToOne
	@JsonIgnore  
	private User user; 
	
	@ManyToOne
	@JsonIgnore
	Post post;
}
