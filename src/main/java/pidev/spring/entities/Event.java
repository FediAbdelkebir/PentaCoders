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
@ToString
@EqualsAndHashCode
public class Event implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String Title;
	@Column
	private String Description;
	@Column 
	private Date DateStart;
	@Column 
	@Temporal(TemporalType.DATE)
	private Date DateEnd;
	@Column 
	private int Nbrplace;
	@Column 
	private EventType Type;
	@Column 
	private boolean Trouphy;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<User> users;
}
