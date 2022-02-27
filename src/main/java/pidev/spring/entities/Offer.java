package pidev.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Offer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int idOffer;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateExp;
	@Enumerated(EnumType.STRING)
	@Column
	private CategoryOffer category;
	@Column
	private String image;
	@Column 
	private int point; 
	@Column
	private String address; 
	@Column 
	private int limitedNumber; 
	@Column 
	private int personsNumber; 
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<User> users;

	public void affectUser(User u) {
		users.add(u);
	}
	
	
}
