package pidev.spring.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class Comment   {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;       
	private String description ;  
	private String likes ;   
	@Temporal(TemporalType.DATE)
	private Date DateComment ;
    
	@ManyToOne 
	@JsonIgnore
	Article article; 
	@ManyToOne 
	@JsonIgnore
	Post post; 
	@ManyToOne
	@JsonIgnore
	User user;
	
	
	
}
