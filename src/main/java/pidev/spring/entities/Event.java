package pidev.spring.entities;
import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@EqualsAndHashCode
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
	private Date dateStart;
	@Column 
	@Temporal(TemporalType.DATE)
	private Date dateEnd;
	@Column 
	private int nbrplace;
	@Column 
	private EventType type;
	@Column 
	private boolean trouphy;
}
