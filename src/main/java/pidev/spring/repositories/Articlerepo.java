package pidev.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import  pidev.spring.entities.Article;
import pidev.spring.entities.ArticleCategory;


@Repository
public interface Articlerepo extends JpaRepository<Article, Long>{ 
	
	  List<Article> findByCategory(ArticleCategory category); 
	//List<Article> findByComments();
	 
	
	
}
