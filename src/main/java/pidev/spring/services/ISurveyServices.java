package pidev.spring.services;

import java.util.List;


import pidev.spring.entities.SurveyQuestion;

public interface ISurveyServices {
	
	
	List<SurveyQuestion> retrieveAllSurvey();
	
	SurveyQuestion addSurvey(SurveyQuestion s,Long idUser);
	
	SurveyQuestion updateSurvey(SurveyQuestion s,Long idUser);
	
	void deleteSurvey(Integer id);
	

}
