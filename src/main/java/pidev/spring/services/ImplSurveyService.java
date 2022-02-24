package pidev.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pidev.spring.entities.Review;
import pidev.spring.entities.SurveyQuestion;
import pidev.spring.entities.User;
import pidev.spring.repositories.ReviewRepository;
import pidev.spring.repositories.SurveyRepository;
import pidev.spring.repositories.UserRepository;

@Service
public class ImplSurveyService implements ISurveyServices {

	
	@Autowired 
	SurveyRepository SurveyRepo;
	@Autowired 
	UserRepository userRepo;
	@Override
	public List<SurveyQuestion> retrieveAllSurvey() {
		List<SurveyQuestion> survey = (List<SurveyQuestion>) SurveyRepo.findAll();
		return survey;
	}
	
	@Override
	public SurveyQuestion addSurvey(SurveyQuestion s, Long idUser ) {
		
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
	

}
