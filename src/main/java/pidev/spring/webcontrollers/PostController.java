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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pidev.spring.entities.Article;
import pidev.spring.entities.Post;
import pidev.spring.services.IpostService; 

@RestController 
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/post")

public class PostController { 
	
	@Autowired 
	IpostService postservice;
	
	//http:localhost:8081/SpringMVC/centre/retrieve-all-centres
  	@GetMapping("/retrieve-all-posts")
    @ResponseBody
 	public List<Post> getPostes() {
	List<Post> listPostes = postservice.retrieveAllPosts();
		return listPostes;
    }  
  	
	// http://localhost:8081/SpringMVC/article/retrieve-article/1
	@GetMapping("/retrieve-post/{post-id}")		
	@ResponseBody
	public Post retrievePost(@PathVariable("post-id") int id) {
		
		return  postservice.retrievePost(id);
		}


	// http://localhost:8081/SpringMVC/article/add-article
	@PostMapping("/add-post/{idUser}")
	@ResponseBody
	Post addpost(@RequestBody Post c ,@PathVariable Long idUser)
	{
		Post post =postservice.AjouterPost(c,idUser);
	    return post;
	 }

  //http://localhost:8087/SpringMVC/centre/modify-article
   @PutMapping("/modify-post/{idUser}")
   @ResponseBody
    public Post modifypost(@RequestBody Post c,@PathVariable Long idUser) {
    return postservice.UpdatePost(c,idUser);
  }   
   

	// http://localhost:8081/SpringMVC/article/remove-article/{article-id}
	@DeleteMapping("/remove-post/{post-id}")
	@ResponseBody
	public void removePost(@PathVariable("post-id") int id) {
		postservice.deletePost(id);
	}
	
	@GetMapping("/retrieve-postbydateasc")
    @ResponseBody
 	public List<Post> retrieveByDateasc() {
	List<Post> listposts = postservice.retrieveByDateAsc();
		 return listposts;
    }    
	
	@GetMapping("/retrieve-postbydatedesc")
    @ResponseBody
 	public List<Post> retrieveByDatedesc() {
	List<Post> listpostss = postservice.retrieveByDateDesc();
		 return listpostss;
    }   
	

	

}
