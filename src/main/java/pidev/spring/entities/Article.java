package pidev.spring.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@AllArgsConstructor 
@NoArgsConstructor 
@ToString 
@EqualsAndHashCode
public class Article  {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long idArticle; 
	private String title; 
	private String Description; 
	@Temporal(TemporalType.DATE)
	private Date dateCreation;  
	private String Image;  
	@Enumerated(EnumType.STRING) 
	private ArticleCategory category; 
	private int nbLike;
	
       @OneToMany(cascade = CascadeType.ALL, mappedBy="article") 
       @JsonIgnore
       private Set<Comment> Comments; 
       
       @ManyToOne(cascade = CascadeType.ALL) 
       @JsonIgnore
       User user; 
       
       @OneToMany(cascade = CascadeType.ALL, mappedBy="article")
       private Set<LikeArticle> LikeArticles;
       
       //@OneToMany(cascade = CascadeType.ALL, mappedBy="article") 
   	  // @JsonIgnore
   	  // private List<LikeArticle> likeArticles; 
       
      

}
