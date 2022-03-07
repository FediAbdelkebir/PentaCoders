package pidev.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import pidev.spring.entities.Review;
import pidev.spring.repositories.ReviewRepository;
import pidev.spring.repositories.SurveyRepository;
import pidev.spring.repositories.UserRepository;
import pidev.spring.services.IReviewServices;
import pidev.spring.services.IStat;
import pidev.spring.services.ISurveyServices;

@RestController
@RequestMapping("/stat")
public class StatController {
	
	@Autowired
	IReviewServices reveiwServ;
	@Autowired
	ISurveyServices SurveyServ;
	@Autowired
	IStat StatServ;
	
	
	@GetMapping("/CountReviewByuser/{idUser}")
	@ResponseBody
	@ApiOperation(value="Count Review")
	int nbrReclamationByUser(@PathVariable Long idUser) {
	return StatServ.nbreReviewByUser(idUser);
}
	
	@GetMapping("/CountReviewBycategorieCompany")
	@ResponseBody
	@ApiOperation(value="Count Review: Company")
	int nbrReviewBycategorieCompany() {
	return StatServ.nbreReviewTypeCompany();
}
	
	@GetMapping("/CountReviewBycategorieEmployee")
	@ResponseBody
	@ApiOperation(value="Count Review: Employee")
	int nbrReviewBycategorieEmployee() {
	return StatServ.nbreReviewTypeEmplyee();
}
	
	@GetMapping("/CountReviewByReviewPublic")
	@ResponseBody
	@ApiOperation(value="Count Review: Public")
	int nbrReviewByTypeReviewPublic() {
	return StatServ.nbreReviewTypePublic();
}
	
	@GetMapping("/CountReviewByReviewAnnonyme")
	@ResponseBody
	@ApiOperation(value="Count Review: Annonyme")
	int nbrReviewByTypeReviewAnnonyme() {
	return StatServ.nbreReviewTypeAnnonyme();
}
	
	//Survey
	
	@GetMapping("/CountSurveyByuser/{idUser}")
	@ResponseBody
	@ApiOperation(value="Count Survey")
	int nbrSurveyByUser(@PathVariable Long idUser) {
	return StatServ.nbreSurveyByUser(idUser);
}
	
	@GetMapping("/CountSurveyByAnswer/{SurveyAnswer}")
	@ResponseBody
	@ApiOperation(value="Count SurveyByAnswer")
	int nbrSurveyByAnswer(@PathVariable Integer SurveyAnswer) {
	return StatServ.nbreQuestionBySurveyAnswer(SurveyAnswer);
}

}

