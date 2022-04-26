package pidev.spring.webcontrollers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pidev.spring.entities.Article;
import pidev.spring.entities.ArticleCategory;
import pidev.spring.services.IarticleService;

@RestController 
@CrossOrigin(origins = "http://localhost:4200")
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
		return articleservice.retrieveArticles(id);
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
	
	// Select by article Categorie 
	@GetMapping("/articleCat") 
     @ResponseBody 
	 List<Article> retrieveByCat(@RequestParam ArticleCategory category){
		 return articleservice.retrieveByCategorie(category);
	} 
	
	@GetMapping("/retrieve-articlebydateasc")
    @ResponseBody
 	public List<Article> retrieveByDateasc() {
	List<Article> listarticle = articleservice.retrieveByDateAsc();
		 return listarticle;
    }   
	

	@GetMapping("/retrieve-articlebydatedsc")
    @ResponseBody
 	public List<Article> retrieveByDatedsc() {
	List<Article> listarticle = articleservice.retrieveByDateDesc();
		 return listarticle;
    }   
	
	@GetMapping("/find-articlewithpagination/{offset}/{pagesize}") 
	@ResponseBody 
	public Page<Article> findarticlewithPagination (@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize){
		return articleservice.findarticlewithPagination(offset, pagesize);
	} 
	
	@GetMapping(value="/search-title/{title}")
	@ResponseBody
	public List<Article> getTitlesearch(@PathVariable("title") String title) {
	return articleservice.searchTitle(title);
			} 
	
	@GetMapping("/retrieve-like-cat")
    @ResponseBody
 	public List<Article> retrieveByLikeCat(@RequestParam ArticleCategory category) {
	List<Article> listarticle = articleservice.retrieveByNbLike(category);
		 return listarticle;
    }
	
	

}
