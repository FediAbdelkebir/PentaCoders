package pidev.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import pidev.spring.service.ILikeArticle;
import pidev.spring.service.IarticleService;
import pidev.spring.service.IcommentService;
import pidev.spring.service.IpostService;
import pidev.spring.service.Istat;


@RestController
@RequestMapping("/stat")
public class StatController {
  
	@Autowired
	Istat statserv;
	@Autowired
	IarticleService articleserv;
	@Autowired
	IcommentService commentserv;
	@Autowired
	ILikeArticle likeserv; 
	@Autowired 
	IpostService postserv;
	
	
	@GetMapping("/CountArticleuser/{idUser}")
	@ResponseBody
	@ApiOperation(value="Count article for each user")
	int nbrReclamationByUser(@PathVariable Long idUser) {
	return statserv.nbreArticleByUser(idUser);
} 
	
	@GetMapping("/CountArticleeducation/")
	@ResponseBody
	@ApiOperation(value="Count education article")
	int nbrArticleeducation() {
	return statserv.nbreArticleByCategoryeduc();
}
	
	@GetMapping("/CountArticleTechnology/")
	@ResponseBody
	@ApiOperation(value="Count Tech article")
	int nbrArticletech() {
	return statserv.nbreArticleByCategoryTech();
} 
	
	@GetMapping("/CountArticlehealth/")
	@ResponseBody
	@ApiOperation(value="Count health article")
	int nbrArticlehealth() {
	return statserv.nbreArticleByCategoryHealth();
} 
	
	@GetMapping("/CountArticleselfdev/")
	@ResponseBody
	@ApiOperation(value="Count selfdev article")
	int nbrArticleselfd() {
	return statserv.nbreArticleByCategorySel();
}
	@GetMapping("/CountArticleenter/")
	@ResponseBody
	@ApiOperation(value="Count entert article")
	int nbrArticleenterta() {
	return statserv.nbreArticleByCategoryEnt();
	}
	@GetMapping("/CountLikeUser/{idUser}")
	@ResponseBody
	@ApiOperation(value="Count like user")
	int nbrLikeuser(@PathVariable Long idUser) {
	return statserv.nbreLikeByUser(idUser); }
	
	
} 
	
	
	
	


