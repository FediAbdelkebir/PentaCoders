package pidev.spring.webcontrollers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pidev.spring.entities.LikeArticle;
import pidev.spring.entities.ReactionPost;
import pidev.spring.repositories.Articlerepo;
import pidev.spring.repositories.Postrepo;
import pidev.spring.repositories.UserRepository;
import pidev.spring.services.ILikeArticle;
import pidev.spring.services.IreactionService;
@RestController 
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/reaction")
public class ReactionPostController {
  
	@Autowired
	IreactionService reactionService; 
	@Autowired
	UserRepository userRepo ;
	@Autowired
	Postrepo postrepo ; 
	
	@PostMapping("/postrecat/{idPost}/{idUser}")
	@ResponseBody
	public String addLike(@RequestBody ReactionPost l,@PathVariable int idPost,@PathVariable Long idUser) 
	{
	     return reactionService.addReaction(l, idPost, idUser);
	} 
	
	
	@GetMapping(value ="/retrieve-all-likes")
	@ResponseBody
	public List<ReactionPost> getrecation() {
	
	return reactionService.retrieveAllReaction();
	} 
	
}
