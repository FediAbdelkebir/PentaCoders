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

import pidev.spring.entities.Article;
import pidev.spring.service.IarticleService;

@RestController 
@RequestMapping("/article")

public class ArticleController {

	@Autowired 
	IarticleService articleservice;
	
	//http:localhost:8081/SpringMVC/article/retrieve-all-article
  	@GetMapping("/retrieve-all-article")
    @ResponseBody
 	public List<Article> getArticle() {
	List<Article> listarticle = articleservice.retrieveAllArticles(); 
		 return listarticle;
    }   
  	
	// http://localhost:8081/SpringMVC/article/retrieve-article/1
	@GetMapping("/retrieve-article/{article-id}")		
	@ResponseBody
	public Article retrieveArticles(@PathVariable("article-id") Long id) {
		
		return  articleservice.retrieveArticles(id);
		}


	// http://localhost:8081/SpringMVC/article/add-article
	@PostMapping("/add-article/{idUser}")
	@ResponseBody
	Article addArticle(@RequestBody Article a,@PathVariable Long idUser)
	{
		Article article =articleservice.AjouterArticle(a,idUser);
	    return article;
	 }

  //http://localhost:8087/SpringMVC/centre/modify-article
   @PutMapping("/modify-article/{idUser}")
   @ResponseBody
    public Article modifyArticle(@RequestBody Article a,@PathVariable Long idUser) {
    return articleservice.UpdateArticle(a,idUser);
  }  
   
	// http://localhost:8081/SpringMVC/article/remove-article/{article-id}
	@DeleteMapping("/remove-article/{article-id}")
	@ResponseBody
	public void removeArticle(@PathVariable("article-id") Long id) {
		articleservice.deleteArticle(id);
	}

// 

}
