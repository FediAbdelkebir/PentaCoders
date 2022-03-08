package pidev.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pidev.spring.services.Stat;

@RestController
@RequestMapping("/Stat")
@Api(tags = "stat Controller")
public class StatController {
	
	@Autowired
	Stat service;
	
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
	

	@GetMapping("/NbrOfferByUser")
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
	


}
