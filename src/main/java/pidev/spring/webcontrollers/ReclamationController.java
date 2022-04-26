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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pidev.spring.entities.Reclamation;
import pidev.spring.entities.StatusReclamation;
import pidev.spring.services.ServiceReclamation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Reclamation")
@Api(tags = "Reclamation Controller")
public class ReclamationController {
	
	@Autowired
	ServiceReclamation reclamationService;
	
	@GetMapping("/ShowAllReclamations")
	@ResponseBody
	@ApiOperation(value="Show all Reclamation")
	List<Reclamation> retrieveAllReclamations(Long idUser){
		return reclamationService.retrieveAllReclamations(idUser);
	}
	
	@PostMapping("/AddReclamation/{idUser}")
	@ResponseBody
	@ApiOperation(value="Add reclamation")
	Reclamation addReclamation(@RequestBody Reclamation r, @PathVariable Long idUser){
		return reclamationService.addReclamation(r, idUser);
	}
	
	/*@PutMapping("/UpdateReclamation/{idUser}")
	@ResponseBody
	@ApiOperation(value="Update reclamation")
	Reclamation updateReclamation(@RequestBody Reclamation r, @PathVariable Long idUser){
		return reclamationService.updateReclamation(r,idUser);
	}*/
	
	@GetMapping("/ShowReclamation/{id}")
	@ResponseBody
	@ApiOperation(value="Show reclamation by id ")
	Reclamation retrieveReclamation(@PathVariable(name="id") int id, Long idUser){
		return reclamationService.retrieveReclamation(id, idUser);
	}
	
	@DeleteMapping("/DeleteReclamation/{id}")
	@ApiOperation(value="Delete reclamation")
	void deleteReclamation(@PathVariable(name="id") int id, Long idUser){
		reclamationService.deleteReclamation(id, idUser);
	}
	

	@PostMapping("/AffectUserToReclamation/{idUser}/{idReclamation}")
	@ResponseBody
	@ApiOperation(value="Affect reclamation to user")
	void affectUserToReclamation(@PathVariable int idReclamation, @PathVariable Long idUser){
		reclamationService.affectUserToReclamation(idReclamation, idUser);
	}
	
	@GetMapping("/FindReclamationByType")
	@ResponseBody
	@ApiOperation(value="Find by type")
	List<Reclamation> retrieveByType(@RequestParam StatusReclamation status, Long idUser){
		return reclamationService.retrieveByType(status, idUser);
	}
	
	@GetMapping("/FindReclamationByCreationDateAsc")
	@ResponseBody
	@ApiOperation(value="Find by creation date Asc")
	List<Reclamation> retrieveByCreationDateAsc(){
		return reclamationService.retrieveByCreationDateAsc();
	}
	
	@GetMapping("/FindReclamationByCreationDateDesc")
	@ResponseBody
	@ApiOperation(value="Find by creation date Desc")
	List<Reclamation> retrieveByCreationDateDesc(){
		return reclamationService.retrieveByCreationDateDesc();
	}
	
	@GetMapping("/FindReclamationByProcessingDateAsc")
	@ResponseBody
	@ApiOperation(value="Find by processing date Asc")
	List<Reclamation> retrieveByProcessingDateAsc(){
		return reclamationService.retrieveByProcessingDateAsc();
	}
	
	@GetMapping("/FindReclamationByProcessingDateDesc")
	@ResponseBody
	@ApiOperation(value="Find by processing date Desc")
	List<Reclamation> retrieveByProcessingDateDesc(){
		return reclamationService.retrieveByProcessingDateDesc();
	}
	
	@GetMapping("/ShowByKeyword/{keyword}")
	@ResponseBody
	@ApiOperation(value="Find by keyword")
	List<Reclamation> retrieveAllReclamationsByKeyword(@PathVariable String keyword, Long idUser){
		return reclamationService.retrieveAllReclamationsByKeyword(keyword, idUser);
	}
	
	@PutMapping("/TreatReclamation/{idReclamation}/{idUser}")
	@ResponseBody
	@ApiOperation(value="Treat reclamation")
	void treatReclamation(@PathVariable int idReclamation, @PathVariable Long idUser){
		reclamationService.treatReclamation(idReclamation, idUser);
	}
	
	@GetMapping("/ShowReclamationByUser/{idUser}")
	@ResponseBody
	List<Reclamation> retrieveReclamationsByUser(@PathVariable Long idUser) {
		return reclamationService.retrieveReclamationsByUser(idUser);
	}

	@PostMapping("/VerifReclamationOffer/{idOffer}/{idUser}")
	@ResponseBody
	void verifReclamationOffer(@RequestBody Reclamation r, @PathVariable int idOffer, @PathVariable Long idUser){
		reclamationService.verifReclamationOffer(r, idOffer, idUser);
	}

}