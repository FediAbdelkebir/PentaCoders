package pidev.spring.services;

import java.util.List;

import pidev.spring.entities.Review;



public interface IReviewServices {

	
List<Review> retrieveAllReview();
	
	Review addReviewCompany(Review r,Long idUser);
	
	Review addReviewEmployee(Review r,Long idUser);
	
	Review updateReviewCompany(Review r,Long idUser);
	
	Review updateReviewEmployee(Review r,Long idUser);
	
	void deleteReview(Integer id);
	
	Review addReviewEmployeEtAffecter(Review R, Long idUser);
	
	Review addReviewCompanyEtAffecter(Review R, Long idUser);
	
	

}
