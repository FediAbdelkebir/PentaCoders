package pidev.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Post implements Serializable{
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
	@Column
    private String EmployeeName;  
	@Column
    private String Title; 
	@Column
    private String Description; 
	@Column
    @Temporal(TemporalType.DATE)
    private Date date_creation; 
	@Column
    private String Image;  
	@Column
	private int likes;  
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	private User user;
	
}
