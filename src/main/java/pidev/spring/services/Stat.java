package pidev.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pidev.spring.entities.CategoryReview;
import pidev.spring.entities.Review;
import pidev.spring.entities.TypeReview;
import pidev.spring.repositories.ReviewRepository;
import pidev.spring.repositories.SurveyRepository;
import pidev.spring.repositories.UserRepository;

@Service
public class Stat implements IStat{

	
	@Autowired 
	ReviewRepository ReviewRepo;
	@Autowired 
	UserRepository userRepo;
	@Autowired 
	SurveyRepository SurveyRepo;
	
	@Override
	public int nbreReviewByUser(Long idUser) {
		
		return ReviewRepo.findByUserIdUser(idUser).size() ;
	}

	@Override
	public int nbreReviewTypeCompany() {
		
		return ReviewRepo.findByCategory(CategoryReview.Company).size();
	}

	@Override
	public int nbreReviewTypeEmplyee() {
		
		return ReviewRepo.findByCategory(CategoryReview.Employee).size();
	}

	@Override
	public int nbreReviewTypePublic() {
	
		return ReviewRepo.findByReview(TypeReview.NORMAL).size();
	}

	@Override
	public int nbreReviewTypeAnnonyme() {
		
		return ReviewRepo.findByReview(TypeReview.ANNONYME).size();
	}

	@Override
	public int nbreSurveyByUser(Long idUser) {
		
		return SurveyRepo.findByUserIdUser(idUser).size();
	}

	@Override
	public int nbreQuestionBySurveyAnswer(int SurveyAnswer) {
	
		return SurveyRepo.findBySurveyAnswerId(SurveyAnswer).size();
	}
	
	
	
}
