package pidev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pidev.spring.entities.Article;
import pidev.spring.entities.ArticleCategory;

@Service
public interface IarticleService {
	Article AjouterArticle(Article a, Long idUser);  
	Article UpdateArticle(Article a ,Long idUser); 
	  List<Article> retrieveAllArticles(); 
	   List<Article> retrieveByCategorie(ArticleCategory category);
	  Article retrieveArticles(Long id); 
	  void deleteArticle(Long id); 
}
