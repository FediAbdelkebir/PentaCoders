package pidev.spring.webcontrollers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import pidev.spring.entities.Article;
import pidev.spring.entities.LikeArticle;
import pidev.spring.entities.User;
import pidev.spring.repositories.Articlerepo;
import pidev.spring.repositories.UserRepository;
import pidev.spring.services.ILikeArticle;
import pidev.spring.services.ImpLikeArt;

@RestController 
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/like")
public class LikeArticleController {  
	
	@Autowired
	ILikeArticle likeservice; 
	@Autowired
	UserRepository userRepo ;
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
	
	@PutMapping("/modify-Like/{idUser}")
	   @ResponseBody
	    public LikeArticle modifyArticle(@RequestBody LikeArticle l,@PathVariable Long idUser) {
	    return likeservice.UpdateLike(l,idUser);
	  }  
	
	@DeleteMapping("/remove-like/{likeArticle-id}")
	@ResponseBody
	public void removeArticle(@PathVariable("likeArticle-id") Long id) {
		likeservice.deleteLike(id);
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
