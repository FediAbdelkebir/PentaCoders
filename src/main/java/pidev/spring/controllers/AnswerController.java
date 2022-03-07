package pidev.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pidev.spring.entities.SurveyAnswer;
import pidev.spring.entities.SurveyQuestion;
import pidev.spring.services.IAnswerServices;
import pidev.spring.services.ISurveyServices;

@RestController
@RequestMapping("/Answer")
public class AnswerController {
	
	@Autowired
	IAnswerServices AnswerServ;
	
	
	
	@GetMapping("/retrieve-all-Answer")
	@ResponseBody
	public List<SurveyAnswer> getAnswer() {
	List<SurveyAnswer> listAnswer = AnswerServ.retrieveAllAnswer();
	return listAnswer;
	}
	//affiche by id
	
	@GetMapping("/retrieve-Answer/{Answer-id}")
	@ResponseBody
	public SurveyAnswer retrieveAnswer(@PathVariable("Answer-id") Integer id) {
	return AnswerServ.retrieveAnswer(id);
	}

}
