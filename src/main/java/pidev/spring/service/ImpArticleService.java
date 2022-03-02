package pidev.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pidev.spring.entities.Article;
import pidev.spring.entities.ArticleCategory;
import pidev.spring.entities.User;
import pidev.spring.repositories.Articlerepo;
import pidev.spring.repositories.UserRepo;

@Service
public class ImpArticleService implements IarticleService {


	@Autowired 
	Articlerepo articlerepo;  
	
	@Autowired 
	UserRepo userRepo; 
	
	@Override
	public Article AjouterArticle(Article a , Long idUser) {
		// TODO Auto-generated method stub 
		User u =userRepo.findById(idUser).orElse(null); 
		a.setUser(u);
		return  articlerepo.save(a);
	}

	@Override
	public Article UpdateArticle(Article a, Long idUser) {
		// TODO Auto-generated method stub 
		User u =userRepo.findById(idUser).orElse(null); 
		a.setUser(u);
		return  articlerepo.save(a);
	}

	@Override
	public List<Article> retrieveAllArticles() {
		List<Article> articles= (List<Article>) articlerepo.findAll();
		return  articles;  
	}

	@Override
	public Article retrieveArticles(Long id) {
		// TODO Auto-generated method stub
		return articlerepo.findById(id).orElse(null);
	}

	@Override
	public void deleteArticle(Long id) {
		// TODO Auto-generated method stub 
		articlerepo.deleteById(id);
	}

	@Override
	public List<Article> retrieveByCategorie(ArticleCategory category) {
		// TODO Auto-generated method stub
		return articlerepo.findByCategory(category);
	}

	@Override
	public List<Article> retrieveByDate() {
		 //TODO Auto-generated method stub
		return articlerepo.findByOrderByDateCreation();
	} 
	
	

	@Override
	public Page<Article> findarticlewithPagination(int offset,int pagesize) {
		Page<Article> art = articlerepo.findAll(PageRequest.of(offset, pagesize)); 
		return art;
	}

	@Override
	public List<Article> searchTitle(String title) {
		// TODO Auto-generated method stub
		return articlerepo.searchTitle(title);
	} 
	
	

	//@Override
	//public List<Article> retrieveByCategorie(ArticleCategory Articlecat) {
		//TODO Auto-generated method stub
		//return articlerepo.findByArticlecat(Articlecat);
	//}





	

}
