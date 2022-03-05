package pidev.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import pidev.spring.entities.Article;
import pidev.spring.entities.ArticleCategory;

@Service
public interface IarticleService {
	Article AjouterArticle(Article a, Long idUser);  
	Article UpdateArticle(Article a ,Long idUser); 
	  List<Article> retrieveAllArticles(); 
	  List<Article> retrieveByCategorie(ArticleCategory category); 
	  List<Article> retrieveByDateAsc(); 
	  List<Article> retrieveByDateDesc(); 
	  Page<Article> findarticlewithPagination(int offset,int pagesize); 
	  List<Article> searchTitle(String title);
	  Article retrieveArticles(Long id); 
	  void deleteArticle(Long id); 
}
