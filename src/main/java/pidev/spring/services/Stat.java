package pidev.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pidev.spring.entities.ArticleCategory;
import pidev.spring.entities.CategoryOffer;
import pidev.spring.entities.CategoryReview;
import pidev.spring.entities.StatusReclamation;
import pidev.spring.entities.TypeReview;
import pidev.spring.entities.User;
import pidev.spring.repositories.Articlerepo;
import pidev.spring.repositories.LikeArtRepo;
import pidev.spring.repositories.OfferRepo;
import pidev.spring.repositories.ReclamationRepo;
import pidev.spring.repositories.ReviewRepository;
import pidev.spring.repositories.SurveyRepository;
import pidev.spring.repositories.UserRepository;


@Service
public class Stat implements IStat{
	
	@Autowired
	ReclamationRepo reclamationRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	OfferRepo offerRepo;
	@Autowired 
	ReviewRepository ReviewRepo;
	@Autowired 
	SurveyRepository SurveyRepo; 
	@Autowired 
    Articlerepo articlerepo;
   
    @Autowired 
    LikeArtRepo likeRepo;

	/*	Reclamation */
	
	@Override
	public int nbrReclamationByUser(Long idUser){
		return reclamationRepo.findByUserIdUser(idUser).size();
	}

	@Override
	public int nbrReclamationTypeWaiting() {
		return reclamationRepo.findAllByStatus(StatusReclamation.WAITING).size();
	}

	@Override
	public int nbrReclamationTypeProcessed() {
		return reclamationRepo.findAllByStatus(StatusReclamation.PROCESSED).size();
	}

	@Override
	public int nbrReclamationTypeInprogress() {
		return reclamationRepo.findAllByStatus(StatusReclamation.INPROGRESS).size();
	}

	/* Offer */

	@Override
	public int nbrOfferByUser(Long idUser) {
		User u = userRepo.findById(idUser).orElse(null);
		return offerRepo.findByUsers(u).size();
	}

	@Override
	public int nbrOfferCategoryServices() {
		return offerRepo.findAllByCategory(CategoryOffer.SERVICES).size();
	}

	@Override
	public int nbrOfferCategoryShopping() {
		return offerRepo.findAllByCategory(CategoryOffer.SHOPPING).size();
	}

	@Override
	public int nbrOfferCategoryHobbies() {
		return offerRepo.findAllByCategory(CategoryOffer.HOBBIES).size();
	}

	@Override
	public int nbrOfferCategoryTraining() {
		return offerRepo.findAllByCategory(CategoryOffer.TRAINING).size();
	}

	@Override
	public int nbrOfferCategoryFood() {
		return offerRepo.findAllByCategory(CategoryOffer.FOOD).size();
	}

	@Override
	public int nbrOfferCategoryHome() {
		return offerRepo.findAllByCategory(CategoryOffer.HOME).size();
	}

	@Override
	public int nbrOfferCategoryOther() {
		return offerRepo.findAllByCategory(CategoryOffer.OTHER).size();
	}
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
	 @Override
	    public int nbreArticleByUser(Long idUser) {
	        // TODO Auto-generated method stub
	        return articlerepo.findByUserIdUser(idUser).size();
	    }

	    @Override
	    public int nbreLikeByUser(Long idUser) {
	        // TODO Auto-generated method stub
	        return likeRepo.findByUserIdUser(idUser).size();
	    } 




	    @Override
	    public int nbreArticleByCategoryeduc() {
	        // TODO Auto-generated method stub
	        return articlerepo.findByCategory(ArticleCategory.Education).size();
	    }



	    @Override
	    public int nbreArticleByCategoryTech() {
	        // TODO Auto-generated method stub
	        return articlerepo.findByCategory(ArticleCategory.Technology).size();
	    }




	    @Override
	    public int nbreArticleByCategoryHealth() {
	        // TODO Auto-generated method stub
	        return articlerepo.findByCategory(ArticleCategory.Health).size();
	    }

	    @Override
	    public int nbreArticleByCategoryEnt() {
	        // TODO Auto-generated method stub
	        return articlerepo.findByCategory(ArticleCategory.Entertainment).size();
	    }

	    @Override
	    public int nbreArticleByCategorySel() {
	        // TODO Auto-generated method stub
	        return articlerepo.findByCategory(ArticleCategory.Selfdeveolpment).size();
	    }



	
	
}
