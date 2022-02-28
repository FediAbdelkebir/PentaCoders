package pidev.spring.services;

import java.util.List;

import pidev.spring.entities.SurveyAnswer;


public interface IAnswerServices {
	
		List<SurveyAnswer> retrieveAllAnswer();
	
		SurveyAnswer retrieveAnswer(Integer id);

}
