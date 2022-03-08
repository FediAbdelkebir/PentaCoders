package pidev.spring.services;

import java.util.List;

import org.springframework.data.domain.Page;

import pidev.spring.entities.SurveyQuestion;

public interface ISurveyServices {
	
	
	List<SurveyQuestion> retrieveAllSurvey();
	
	SurveyQuestion retrieveSurvey(Integer id);
	
	SurveyQuestion addSurvey(SurveyQuestion s,Long idUser);
	
	SurveyQuestion updateSurvey(SurveyQuestion s,Long idUser);
	
	SurveyQuestion AjouterReponse(Integer idquestion,Long idUser,Integer idAnswer);
	
	void deleteSurvey(Integer id);
	
	Page<SurveyQuestion> findquestionwithPagination(int offset,int pagesize);
	
	List<SurveyQuestion> retrieveByDateExpAsc(); 
	List<SurveyQuestion> retrieveByDateExpDesc();
	

}