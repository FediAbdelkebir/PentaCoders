package pidev.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
	@Autowired
    JavaMailSender emailSender;
	
	@Override
	public Article AjouterArticle(Article a , Long idUser) {
		// TODO Auto-generated method stub 
		User u =userRepo.findById(idUser).orElse(null); 
		a.setUser(u); 
		sendSimpleEmail(u.getEmailAddress().toString(), "Article", "votre article est ajouté avec succes");
	
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
	public List<Article> retrieveByDateAsc() {
		 //TODO Auto-generated method stub
		return articlerepo.findByOrderByDateCreationAsc();
	} 
	
	@Override
	public List<Article> retrieveByDateDesc() {
		// TODO Auto-generated method stub
		return articlerepo.findByOrderByDateCreationDesc();
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

	public void sendSimpleEmail(String toAddress, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(toAddress);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        emailSender.send(simpleMailMessage);
    }

	



	

}
