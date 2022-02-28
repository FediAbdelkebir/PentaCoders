package pidev.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pidev.spring.entities.SurveyAnswer;
import pidev.spring.entities.SurveyQuestion;
import pidev.spring.repositories.AnswersRepository;
import pidev.spring.repositories.SurveyRepository;
import pidev.spring.repositories.UserRepository;

@Service
public class ImpAnswerService implements IAnswerServices {

	@Autowired 
	AnswersRepository AnswerRepo;
	@Autowired 
	UserRepository userRepo;
	
	@Override
	public List<SurveyAnswer> retrieveAllAnswer() {
		List<SurveyAnswer> Answer = (List<SurveyAnswer>) AnswerRepo.findAll();
		return Answer;
	}
	
	@Override
	public SurveyAnswer retrieveAnswer(Integer id) {
		SurveyAnswer Answer = AnswerRepo.findById(id).orElse(null);
		return Answer;
	}
	
	
}
