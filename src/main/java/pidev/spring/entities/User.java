package pidev.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	@Column
	private String emailAddress;
	@Column
	private String  firstname  ;
	@Column
	private String lastName ;
	@Column
	private String password;
	@Column
	private Date birth;
	@Column
	private float salary;
	@Column
	private String address;
	@Column
	private int phone;
	
	@ManyToMany(mappedBy = "users" , cascade=CascadeType.ALL)
    @JsonIgnore
	private Set<Role> roles;
	
	@ManyToMany(mappedBy = "users" , cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Event> events;
	
	@OneToMany(mappedBy = "user" , cascade=CascadeType.ALL) 
	@JsonIgnore
	private Set<SurveyQuestion> surveys;
	
	@OneToMany(mappedBy = "user" , cascade=CascadeType.ALL) 
	@JsonIgnore
	private Set<Review> reviews;
	
	@ManyToMany(mappedBy = "users" , cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Messagerie> messageries;
	
	@OneToOne
	private Badge badge;
	
	@ManyToMany(mappedBy = "users" , cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Offer> offers;
	
	@OneToMany(mappedBy = "user" , cascade=CascadeType.ALL) 
	@JsonIgnore
	private Set<Reclamation> reclamations; 
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL) 
	@JsonIgnore
	private Set<Comment> Comments;
	
	

}
