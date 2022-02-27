package pidev.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Reclamation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int idReclamation;
	@Column
	private String objet; 
	@Column
	private String message; 
	@Column
	@Temporal(TemporalType.DATE)
	private Date creationDate; 
	@Column
	@Temporal(TemporalType.DATE)
	private Date processingDate; 
	@Enumerated(EnumType.STRING)
	@Column
	private StatusReclamation status;
	@Column
	private String response; 
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	private User user;
	
	
	
	
}
