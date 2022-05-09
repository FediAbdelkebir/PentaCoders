package pidev.spring.entities;

import java.io.Serializable;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	@Column
	private String firstname;
	@Column
	private String name;
	@Column
	private String emailAddress;
	@Column
	private String username;
	@Column
	private float salary;
	@Column
	private String address;
	@Column
	private int PhoneNumber;
	@Column
	private int Points;
	@Column
	private int Trouphies;
	@Temporal(TemporalType.DATE)
	private Date subDate;
	private String passwd;
	private String confirmPasswd;
	private boolean enabled;

	@ManyToMany(mappedBy="users",cascade = CascadeType.ALL , fetch= FetchType.EAGER)
	@JsonIgnore
	private Set<Role> roles;
	

	@OneToMany(mappedBy = "user" , cascade=CascadeType.ALL)
	private Set<SurveyQuestion> surveys;
	
	@OneToMany(mappedBy = "user" , cascade=CascadeType.ALL)
	private Set<Review> reviews;
	
	@ManyToMany(mappedBy = "users" , cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Messagerie> messageries;
	

	@ManyToMany(cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Offer> offers;
	
	@OneToMany(mappedBy = "user" , cascade=CascadeType.ALL)
	private Set<Reclamation> reclamations;
	
//
	@ManyToMany(mappedBy = "users" , cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Event> events;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JsonIgnore  
	private Set<Event> LikedEvent;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Badge> AcquiredBadges; 
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL) 
	@JsonIgnore
	private Set<Comment> Comments; 
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL) 
	@JsonIgnore
	private Set<LikeArticle> likeArticle; 
	
}
