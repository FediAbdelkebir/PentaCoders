package pidev.spring.services;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pidev.spring.entities.Article;
import pidev.spring.entities.Comment;
import pidev.spring.entities.Post;
import pidev.spring.entities.User;
import pidev.spring.repositories.Articlerepo;
import pidev.spring.repositories.Commentrepo;
import pidev.spring.repositories.Postrepo;
import pidev.spring.repositories.UserRepository;

@Service
public class ImpCommentService implements IcommentService { 
	
	@Autowired 
	Commentrepo commentrepo; 
	@Autowired 
	UserRepository userRepo; 
	@Autowired 
	Postrepo postrepo; 
	@Autowired 
	Articlerepo articlerepo;

	@Override
	public Comment AjouterCommInPost(Comment c, Long idUser,int idPost) {
		// TODO Auto-generated method stub  
		c.setArticle(null);
		User u =userRepo.findById(idUser).orElse(null);  
		Post p=postrepo.findById(idPost).orElse(null); 
		c.setUser(u); 
		c.setPost(p); 
		BadWordFilter.getCensoredText(c.getDescription()); 
		String newDescription = BadWordFilter.getCensoredText(c.getDescription()); 
		//System.out.println(BadWordFilter.getCensoredText(c.getDescription()));
		  //char[] charsStars = new char[c.getDescription().length()];
	      //Arrays.fill(charsStars, '*');
	      //final String stars = new String(charsStars);
		 //System.out.println(c.getDescription());  
	      //String test=c.getDescription().replaceAll("(?i)" +c.getDescription(), stars); 
	      //c.setDescription(test);
	     // System.out.println(test); 
		c.setDescription(newDescription);
		return commentrepo.save(c);  
	} 
	
	@Override
	public Comment AjouterCommInArticle(Comment c, Long idUser,Long idArticle) {
		// TODO Auto-generated method stub
		c.setPost(null);
		User u =userRepo.findById(idUser).orElse(null); 
		Article a =articlerepo.findById(idArticle).orElse(null); 
		c.setUser(u);
		c.setArticle(a); 
		BadWordFilter.getCensoredText(c.getDescription()); 
		String newDescription = BadWordFilter.getCensoredText(c.getDescription()); 
		c.setDescription(newDescription);
		return commentrepo.save(c);
	} 

	@Override
	public Comment UpdateCommInPost(Comment c, Long idUser,int idPost) {
		// TODO Auto-generated method stub  
		c.setArticle(null);
		User u =userRepo.findById(idUser).orElse(null); 
		Post p=postrepo.findById(idPost).orElse(null); 
		c.setUser(u); 
		c.setPost(p); 
		return commentrepo.save(c); 
	} 
	
	@Override
	public Comment UpdateCommInArticle(Comment c, Long idUser,Long idArticle) {
		// TODO Auto-generated method stub 
		c.setPost(null);
		User u =userRepo.findById(idUser).orElse(null);  
		Article a =articlerepo.findById(idArticle).orElse(null); 
		c.setUser(u);
		c.setArticle(a);
		return commentrepo.save(c); 
	}

	@Override
	public List<Comment> retrieveAllComm() {
		List<Comment> comments= (List<Comment>) commentrepo.findAll();
		return  comments; 
	}

	@Override
	public Comment retrieveComm(Long id) {
		// TODO Auto-generated method stub
		return commentrepo.findById(id).orElse(null);
	}

	@Override
	public void deleteComm(Long id) {
		// TODO Auto-generated method stub 
		commentrepo.deleteById(id);
		
	}

	

	
	
	// controle bad words function 
	


    

	

}
