package pidev.spring.entities;
import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
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

public class Event implements Serializable{
	@ApiModelProperty(hidden = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String title;
	@Column
	private String description;
	@Column 
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateStart;
	@Column 
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateEnd;
	@Column 
	@ApiModelProperty(hidden = true)
	private int npDisponible;
	@Column 
	private int npMax;
	@ApiModelProperty(hidden = true)
	@Column 
	private int nbrlikes=0;
	@Column 
	private EventType type;
	@Column
	private EventTags eventTags;
	@Column 
	private boolean trouphy;

	@ManyToMany(cascade=CascadeType.ALL)
	@JsonIgnore
	@ApiModelProperty(hidden = true)
	private Set<User> users;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JsonIgnore 
	@ApiModelProperty(hidden = true)
	private Set<User> UsersLiked;
}
