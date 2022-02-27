package pidev.spring.service;

import java.util.List;

import pidev.spring.entities.Article;


public interface IarticleService {
	Article AjouterArticle(Article a, Long idUser);  
	Article UpdateArticle(Article a ,Long idUser); 
	  List<Article> retrieveAllArticles(); 
	  Article retrieveArticles(Long id); 
	  void deleteArticle(Long id); 
}
