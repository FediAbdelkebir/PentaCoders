package pidev.spring.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
@ToString
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String emailAddress;
	@Column
	private String password;
	@Column
	private Date birthDate;
	@Column
	private float salary;
	@Column
	private String address;
	@Column
	private int PhoneNumber;
	
	@Column
	@ManyToMany(mappedBy = "users" , cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Event> events;
	
}
