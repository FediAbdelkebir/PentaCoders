package pidev.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pidev.spring.entities.Comment;
import pidev.spring.entities.Post;
import pidev.spring.service.IcommentService;


@RestController 
@RequestMapping("/comment")

public class commentController {


	@Autowired 
	IcommentService commentservice;
	
	//http:localhost:8081/SpringMVC/centre/retrieve-all-centres
  	@GetMapping("/retrieve-all-commentaire")
    @ResponseBody
 	public List<Comment> getComment() {
	List<Comment> listcomm = commentservice.retrieveAllComm();
		return listcomm;
    }  
  	
 // http://localhost:8081/SpringMVC/article/retrieve-article/1
 	@GetMapping("/retrieve-commentaire/{commentaire-id}")		
 	@ResponseBody
 	public Comment retrieveComment(@PathVariable("commentaire-id") Long id) {
 		
 		return  commentservice.retrieveComm(id);
 		}


 	// http://localhost:8081/SpringMVC/article/add-article
 	@PostMapping("/add-comment-inpost/{idUser}")
 	@ResponseBody
 	Comment addcommentpost(@RequestBody Comment c,@PathVariable Long idUser)
 	{
 		Comment comment = commentservice.AjouterCommInPost(c, idUser);
 	    return comment;
 	 } 
 	// add comment in article
 	@PostMapping("/add-comment-inarticle/{idUser}")
 	@ResponseBody
 	Comment addcommentarticle(@RequestBody Comment c,@PathVariable Long idUser)
 	{
 		Comment comment = commentservice.AjouterCommInArticle(c, idUser);
 	    return comment;
 	 }

   //http://localhost:8087/SpringMVC/centre/modify-article
    @PutMapping("/modify-comment-inarticle/{idUser}")
    @ResponseBody
     public Comment modifycommentInArticle(@RequestBody Comment c,@PathVariable Long idUser) {
     return commentservice.UpdateCommInArticle(c, idUser);
   }    
    
    @PutMapping("/modify-comment-inpost/{idUser}")
    @ResponseBody
     public Comment modifycommentInPost(@RequestBody Comment c,@PathVariable Long idUser) {
     return commentservice.UpdateCommInPost(c, idUser);
   }   
    

 	// http://localhost:8081/SpringMVC/article/remove-article/{article-id}
 	@DeleteMapping("/remove-comment/{comment-id}")
 	@ResponseBody
 	public void removeComment(@PathVariable("comment-id") Long id) {
 		commentservice.deleteComm(id); 
 	}
 	

}
