package pidev.spring.repositories;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import  pidev.spring.entities.Article;
import pidev.spring.entities.ArticleCategory;


@Repository
public interface Articlerepo extends JpaRepository<Article, Long>{ 
	
	     public List<Article> findByCategory(ArticleCategory category);  
	     public List<Article> findByOrderByDateCreation(); 
	     @Query("SELECT a FROM Article a WHERE a.title LIKE CONCAT('%',:string,'%')")
	 	 public List<Article> searchTitle(@Param("string") String title);

	  // List<Article> findByDateCreation();
	  //@Query("select * from article ORDER BY Date_creation ASC")
	 // List<Article> findByDate_creation();
	  //List<Article> findByDate_creation();
	//List<Article> findByComments();
	 
	
	
}
