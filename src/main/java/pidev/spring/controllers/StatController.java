package pidev.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pidev.spring.services.ServiceReclamation;

@RestController
@RequestMapping("/Stat")
@Api(tags = "stat Controller")
public class StatController {
	
	@Autowired
	ServiceReclamation reclamationService;
	

	@GetMapping("/CountReclamationByUser/{idUser}")
	@ResponseBody
	@ApiOperation(value="Count Reclamations")
	int nbrReclamationByUser(@PathVariable Long idUser){
		return reclamationService.nbrReclamationByUser(idUser);
	}
	
	@GetMapping("/CountReclamationByTypeWaiting")
	@ResponseBody
	@ApiOperation(value="Count Reclamations : Waiting")
	int nbrReclamationTypeWaiting(){
		return reclamationService.nbrReclamationTypeWaiting();
	}
	
	@GetMapping("/CountReclamationByTypeProcessed")
	@ResponseBody
	@ApiOperation(value="Count Reclamations : Processed")
	int nbrReclamationTypeProcessed(){
		return reclamationService.nbrReclamationTypeProcessed();
	}
	
	@GetMapping("/CountReclamationByTypeInProgress")
	@ResponseBody
	@ApiOperation(value="Count Reclamations : Inprogress")
	int nbrReclamationTypeInprogress(){
		return reclamationService.nbrReclamationTypeInprogress();
	}

}
