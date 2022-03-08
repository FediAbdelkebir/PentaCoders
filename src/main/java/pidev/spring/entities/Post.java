package pidev.spring.entities;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Post  { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPost;      
	private String contenu; 
	@Temporal(TemporalType.DATE)
	private Date timeCreation; 
	private String Images; 
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="post")  
	@JsonIgnore
    private Set<Comment> Comments; 
	
	@ManyToOne(cascade = CascadeType.ALL)  
	@JsonIgnore
     User user;
	
}
