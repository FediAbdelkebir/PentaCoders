package pidev.spring.webcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pidev.spring.services.ILikeArticle;
import pidev.spring.services.IReviewServices;
import pidev.spring.services.ISurveyServices;
import pidev.spring.services.IarticleService;
import pidev.spring.services.IcommentService;
import pidev.spring.services.IpostService;
import pidev.spring.services.Stat;

@RestController
@RequestMapping("/Stat")
@CrossOrigin(origins = "http://localhost:4200")
@Api(tags = "stat Controller")
public class StatController {
	
	@Autowired
	Stat service;
	@Autowired
	IReviewServices reveiwServ;
	@Autowired
	ISurveyServices SurveyServ; 

    @Autowired
    IarticleService articleserv;
    @Autowired
    IcommentService commentserv;
    @Autowired
    ILikeArticle likeserv; 
    @Autowired 
    IpostService postserv;
	
	@GetMapping("/CountReclamationByUser/{idUser}")
	@ResponseBody
	@ApiOperation(value="Count Reclamations")
	int nbrReclamationByUser(@PathVariable Long idUser){
		return service.nbrReclamationByUser(idUser);
	}
	
	@GetMapping("/CountReclamationByTypeWaiting")
	@ResponseBody
	@ApiOperation(value="Count Reclamations : Waiting")
	int nbrReclamationTypeWaiting(){
		return service.nbrReclamationTypeWaiting();
	}
	
	@GetMapping("/CountReclamationByTypeProcessed")
	@ResponseBody
	@ApiOperation(value="Count Reclamations : Processed")
	int nbrReclamationTypeProcessed(){
		return service.nbrReclamationTypeProcessed();
	}
	
	@GetMapping("/CountReclamationByTypeInProgress")
	@ResponseBody
	@ApiOperation(value="Count Reclamations : Inprogress")
	int nbrReclamationTypeInprogress(){
		return service.nbrReclamationTypeInprogress();
	}
	
	/* Offer */
	

	@GetMapping("/NbrOfferByUser/{idUser}")
	@ResponseBody
	int nbrOfferByUser(@PathVariable Long idUser){
		return service.nbrOfferByUser(idUser);
	}
	
	@GetMapping("/NbrOfferCategoryServices")
	@ResponseBody
	int nbrOfferCategoryServices(){
		return service.nbrOfferCategoryServices();
	}
	
	@GetMapping("/NbrOfferCategoryShopping")
	@ResponseBody
	int nbrOfferCategoryShopping(){
		return service.nbrOfferCategoryShopping();
	}
	
	@GetMapping("/NbrOfferCategoryHobbies")
	@ResponseBody
	int nbrOfferCategoryHobbies(){
		return service.nbrOfferCategoryHobbies();
	}
	
	@GetMapping("/NbrOfferCategoryTraining")
	@ResponseBody
	int nbrOfferCategoryTraining(){
		return service.nbrOfferCategoryTraining();
	}
	
	@GetMapping("/NbrOfferCategoryFood")
	@ResponseBody
	int nbrOfferCategoryFood(){
		return service.nbrOfferCategoryFood();
	}
	
	@GetMapping("/NbrOfferCategoryHome")
	@ResponseBody
	int nbrOfferCategoryHome(){
		return service.nbrOfferCategoryHome();
	}
	
	@GetMapping("/NbrOfferCategoryOther")
	@ResponseBody
	int nbrOfferCategoryOther(){
		return service.nbrOfferCategoryOther();
	}
	
	@GetMapping("/CountReviewByuser/{idUser}")
	@ResponseBody
	@ApiOperation(value="Count Review")
	int nbrRecviewByUser(@PathVariable Long idUser) {
	return service.nbreReviewByUser(idUser);
}
	
	@GetMapping("/CountReviewBycategorieCompany")
	@ResponseBody
	@ApiOperation(value="Count Review: Company")
	int nbrReviewBycategorieCompany() {
	return service.nbreReviewTypeCompany();
}
	
	@GetMapping("/CountReviewBycategorieEmployee")
	@ResponseBody
	@ApiOperation(value="Count Review: Employee")
	int nbrReviewBycategorieEmployee() {
	return service.nbreReviewTypeEmplyee();
}
	
	@GetMapping("/CountReviewByReviewPublic")
	@ResponseBody
	@ApiOperation(value="Count Review: Public")
	int nbrReviewByTypeReviewPublic() {
	return service.nbreReviewTypePublic();
}
	
	@GetMapping("/CountReviewByReviewAnnonyme")
	@ResponseBody
	@ApiOperation(value="Count Review: Annonyme")
	int nbrReviewByTypeReviewAnnonyme() {
	return service.nbreReviewTypeAnnonyme();
}
	
	//Survey
	
	@GetMapping("/CountSurveyByuser/{idUser}")
	@ResponseBody
	@ApiOperation(value="Count Survey")
	int nbrSurveyByUser(@PathVariable Long idUser) {
	return service.nbreSurveyByUser(idUser);
}
	
	@GetMapping("/CountSurveyByAnswer/{SurveyAnswer}")
	@ResponseBody
	@ApiOperation(value="Count SurveyByAnswer")
	int nbrSurveyByAnswer(@PathVariable Integer SurveyAnswer) {
	return service.nbreQuestionBySurveyAnswer(SurveyAnswer);
} 
	
	@GetMapping("/CountArticleuser/{idUser}")
    @ResponseBody
    @ApiOperation(value="Count article for each user")
    int nbrArticlenByUser(@PathVariable Long idUser) {
    return service.nbreArticleByUser(idUser);
} 

    @GetMapping("/CountArticleeducation/")
    @ResponseBody
    @ApiOperation(value="Count education article")
    int nbrArticleeducation() {
    return service.nbreArticleByCategoryeduc();
}

    @GetMapping("/CountArticleTechnology/")
    @ResponseBody
    @ApiOperation(value="Count Tech article")
    int nbrArticletech() {
    return service.nbreArticleByCategoryTech();
} 

    @GetMapping("/CountArticlehealth/")
    @ResponseBody
    @ApiOperation(value="Count health article")
    int nbrArticlehealth() {
    return service.nbreArticleByCategoryHealth();
} 

    @GetMapping("/CountArticleselfdev/")
    @ResponseBody
    @ApiOperation(value="Count selfdev article")
    int nbrArticleselfd() {
    return service.nbreArticleByCategorySel();
}
    @GetMapping("/CountArticleenter/")
    @ResponseBody
    @ApiOperation(value="Count entert article")
    int nbrArticleenterta() {
    return service.nbreArticleByCategoryEnt();
    }
    @GetMapping("/CountLikeUser/{idUser}")
    @ResponseBody
    @ApiOperation(value="Count like user")
    int nbrLikeuser(@PathVariable Long idUser) {
    return service.nbreLikeByUser(idUser); }


}