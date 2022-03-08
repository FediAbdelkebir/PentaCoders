package pidev.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import pidev.spring.entities.Article;
import pidev.spring.entities.LikeArticle;
import pidev.spring.entities.User;
import pidev.spring.repositories.Articlerepo;
import pidev.spring.repositories.UserRepo;
import pidev.spring.service.ILikeArticle;
import pidev.spring.service.ImpLikeArt;

@RestController 
@RequestMapping("/like")
public class LikeArticleController {  
	
	@Autowired
	ILikeArticle likeservice; 
	@Autowired
	UserRepo userRepo ;
	@Autowired
	Articlerepo articlerepo ;


	@PostMapping("/articlelike/{idArticle}/{idUser}")
	@ResponseBody
	public String addLike(@RequestBody LikeArticle l,@PathVariable Long idArticle,@PathVariable Long idUser) 
	{
	     return likeservice.addLike(l, idArticle, idUser);
	} 
	
	
	@GetMapping(value ="/retrieve-all-likes")
	@ResponseBody
	public List<LikeArticle> getLikes() {
	
	return likeservice.retrieveAllLike();
	} 
	
	/*
	@RequestMapping(method=RequestMethod.PUT,value="/addLike/{idArticle}/{etat}/{idUser}")
    public String addlike(@PathVariable("idUser") Long  idUser,@PathVariable("idArticle") Long  idArticle,@PathVariable boolean  etat){
		
		
		User user=userRepo.findAllById(idUser);
		
		Article article = articlerepo.findById(idArticle).get();
		
		LikeArticle la=new LikeArticle();
		la.setUser(user);
		la.setArticle(article);
		la.setEtat(etat);
		if(etat==true){
		return	impLikeArt.addLike(idUser, idArticle, la);
		}
		else 
			return null;
	    }
	
	*/

} 
