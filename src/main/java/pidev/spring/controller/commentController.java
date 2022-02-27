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
 	public Comment retrievePost(@PathVariable("commentaire-id") Long id) {
 		
 		return  commentservice.retrieveComm(id);
 		}


 	// http://localhost:8081/SpringMVC/article/add-article
 	@PostMapping("/add-comment/{idUser}")
 	@ResponseBody
 	Comment addpost(@RequestBody Comment c,@PathVariable Long idUser)
 	{
 		Comment comment = commentservice.AjouterComm(c,idUser);
 	    return comment;
 	 }

   //http://localhost:8087/SpringMVC/centre/modify-article
    @PutMapping("/modify-comment/{idUser}")
    @ResponseBody
     public Comment modifycomment(@RequestBody Comment c,@PathVariable Long idUser) {
     return commentservice.UpdateComm(c,idUser);
   }   
    

 	// http://localhost:8081/SpringMVC/article/remove-article/{article-id}
 	@DeleteMapping("/remove-comment/{comment-id}")
 	@ResponseBody
 	public void removePost(@PathVariable("comment-id") Long id) {
 		commentservice.deleteComm(id); 
 	}
 	

}
