package pidev.spring.webcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pidev.spring.entities.SurveyQuestion;
import pidev.spring.services.ISurveyServices;



@RestController
@RequestMapping("/survey")
public class SurveyController {
	
	@Autowired
	ISurveyServices SurveyServ;
	
	//Afficher survey
	
	@GetMapping("/retrieve-all-survey")
	@ResponseBody
	public List<SurveyQuestion> getSurvey() {
	List<SurveyQuestion> listSurvey = SurveyServ.retrieveAllSurvey();
	return listSurvey;
	}
	//affiche by id
	
	@GetMapping("/retrieve-Survey/{Survey-id}")
	@ResponseBody
	public SurveyQuestion retrieveSurvey(@PathVariable("Survey-id") Integer id) {
	return SurveyServ.retrieveSurvey(id);
	}
	
			//update survey
			@PutMapping("/modify-survey/{idUser}")
			@ResponseBody
			public SurveyQuestion modifyCentreC(@RequestBody SurveyQuestion survey, @PathVariable Long idUser) {
			return SurveyServ.updateSurvey(survey,idUser);
			}
			
		//Ajouter survey
			
			@PostMapping("/add-survey/{idUser}")
			@ResponseBody
			public SurveyQuestion addsurvey(@RequestBody SurveyQuestion s, @PathVariable Long idUser)
			{
				SurveyQuestion survey = SurveyServ.addSurvey(s,idUser);
			return survey;
			}
		
		//Supprimer survey
			
			@DeleteMapping("/remove-survey/{survey-id}")
			@ResponseBody
			public void RemoveSurvey(@PathVariable("survey-id") Integer id) {
				SurveyServ.deleteSurvey(id);
			}
			
			@PutMapping("/ajouter-reponse/{idUser}/{idquestion}/{idAnswer}")
			@ResponseBody
			public SurveyQuestion AjouterReponse(@PathVariable Integer idquestion, @PathVariable Long idUser, @PathVariable Integer idAnswer) {
			return SurveyServ.AjouterReponse(idquestion, idUser, idAnswer);
			}
			
			//pagination
			@GetMapping("/find-Questionwithpagination/{offset}/{pagesize}") 
			@ResponseBody 
			public Page<SurveyQuestion> findarticlewithPagination (@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize){
				return SurveyServ.findquestionwithPagination(offset, pagesize);
			} 
			
			//Tri date
			@GetMapping("/retrieve-Surveybydateasc")
		    @ResponseBody
		 	public List<SurveyQuestion> retrieveByDateExpAsc() {
			List<SurveyQuestion> survey = SurveyServ.retrieveByDateExpAsc();
				 return survey;
		    }   
			@GetMapping("/retrieve-Surveybydatedesc")
		    @ResponseBody
		 	public List<SurveyQuestion> retrieveByDateExpDesc() {
			List<SurveyQuestion> survey = SurveyServ.retrieveByDateExpDesc();
				 return survey;
		    }   
	
	
}
