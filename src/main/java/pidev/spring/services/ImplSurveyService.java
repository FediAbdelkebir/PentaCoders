package pidev.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import pidev.spring.entities.Review;
import pidev.spring.entities.SurveyAnswer;
import pidev.spring.entities.SurveyQuestion;
import pidev.spring.entities.User;
import pidev.spring.repositories.AnswersRepository;
import pidev.spring.repositories.ReviewRepository;
import pidev.spring.repositories.SurveyRepository;
import pidev.spring.repositories.UserRepository;

@Service
public class ImplSurveyService implements ISurveyServices {

	
	@Autowired 
	SurveyRepository SurveyRepo;
	@Autowired 
	UserRepository userRepo;
	@Autowired 
	AnswersRepository answerRepo;
	
	@Override
	public List<SurveyQuestion> retrieveAllSurvey() {
		List<SurveyQuestion> survey = (List<SurveyQuestion>) SurveyRepo.findAll();
		return survey;
	}
	
	@Override
	public SurveyQuestion addSurvey(SurveyQuestion s, Long idUser ) {
		s.setSurveyAnswer(null);
		User u = userRepo.findById(idUser).orElse(null);
		s.setUser(u);
		return SurveyRepo.save(s);
	}
	@Override
	public SurveyQuestion updateSurvey(SurveyQuestion s, Long idUser) {
		User u = userRepo.findById(idUser).orElse(null);
		s.setUser(u);
		return SurveyRepo.save(s);
	}
	@Override
	public void deleteSurvey(Integer id) {
		SurveyRepo.deleteById(id);		
	}

	@Override
	public SurveyQuestion retrieveSurvey(Integer id) {
		SurveyQuestion survey = SurveyRepo.findById(id).orElse(null);
		return survey;
		
	}

	// hethi ajout mtaa reponse elli tzid juste id ki yjaweb aal question 
	@Override
	public SurveyQuestion AjouterReponse(Integer idquestion,Long idUser,Integer idAnswer) {
		SurveyQuestion surveyQuestion = SurveyRepo.findById(idquestion).orElse(null);
		SurveyAnswer surveyAnswer = answerRepo.findById(idAnswer).orElse(null);
		
		surveyQuestion.setSurveyAnswer(surveyAnswer);
		User u = userRepo.findById(idUser).orElse(null);
		surveyQuestion.setUser(u);
		return SurveyRepo.save(surveyQuestion);
	}

	@Override
	public Page<SurveyQuestion> findquestionwithPagination(int offset, int pagesize) {
		Page<SurveyQuestion> question = SurveyRepo.findAll(PageRequest.of(offset, pagesize)); 
		return question;
	}
	

}
