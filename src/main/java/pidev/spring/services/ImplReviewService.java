package pidev.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pidev.spring.entities.Review;
import pidev.spring.entities.User;
import pidev.spring.repositories.ReviewRepository;
import pidev.spring.repositories.UserRepository;

@Service
public class ImplReviewService implements IReviewServices {

	
	@Autowired 
	ReviewRepository ReviewRepo;
	@Autowired 
	UserRepository userRepo;
	
	@Override
	public List<Review> retrieveAllReview() {
		List<Review> review = (List<Review>) ReviewRepo.findAll();
		return review;
	}

	@Override
	public Review addReviewCompany(Review r , Long idUser ) {
		r.setEmployeeName(null);
		User u = userRepo.findById(idUser).orElse(null);
		r.setUser(u);
		return ReviewRepo.save(r);
	}
	@Override
	public Review addReviewEmployee(Review r, Long idUser) {
		r.setSocieteName(null);
		User u = userRepo.findById(idUser).orElse(null);
		r.setUser(u);
		return ReviewRepo.save(r);
	}

	@Override
	public Review updateReviewEmployee(Review r, Long idUser) {
		r.setSocieteName(null);
		User u = userRepo.findById(idUser).orElse(null);
		r.setUser(u);
		return ReviewRepo.save(r);
	}
	
	@Override
	public Review updateReviewCompany(Review r, Long idUser) {
		r.setEmployeeName(null);
		User u = userRepo.findById(idUser).orElse(null);
		r.setUser(u);
		return ReviewRepo.save(r);
	}

	@Override
	public void deleteReview(Integer id) {
		ReviewRepo.deleteById(id);
		
	}

	
}
