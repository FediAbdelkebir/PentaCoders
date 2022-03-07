package pidev.spring.services;

import java.util.List;

import pidev.spring.entities.CategoryReview;
import pidev.spring.entities.Classification;
import pidev.spring.entities.Review;
import pidev.spring.entities.TypeReview;



public interface IReviewServices {

	
	List<Review> retrieveAllReview();

	List<Review> ClassifictionReview(Review r);
	
	Review addReviewCompany(Review r,Long idUser);
	
	Review addReviewEmployee(Review r,Long idUser);
	
	Review updateReviewCompany(Review r,Long idUser);
	
	Review updateReviewEmployee(Review r,Long idUser);
	
	void deleteReview(Integer id);
	
	Review addReviewEmployeEtAffecter(Review R, Long idUser);
	
	Review addReviewCompanyEtAffecter(Review R, Long idUser);
	
	List<Review> retrieveByCategorie(CategoryReview categorie); 
	
	List<Review> retrieveByType(TypeReview review);
	
	List<Review> searchReviewEm(String EmployeeName);
	
	List<Review> searchReviewSociete(String SocieteName);
	
	List<Review> retrieveByClassification(Classification classf); 

	
	List<Review> retrieveReviewbyUser(Long idUser);


}
