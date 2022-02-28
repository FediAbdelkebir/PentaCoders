package pidev.spring.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Review implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String SocieteName;
	@Column
	private String EmployeeName;
	
	@Column
	private String ContentReview;
	
	//Ennum categorie fiha Employee W Societee
	//Ennumm message fiha Normal or Annonyme
	
	@Enumerated(EnumType.STRING)
	@Column
	private CategoryReview category;
	@Enumerated(EnumType.STRING)
	@Column
	private TypeReview review;
	
	
	@ManyToOne
	@JsonIgnore
	private User user;
}
