package pidev.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pidev.spring.entities.Review;

@Repository
public interface ReviewRepository  extends JpaRepository<Review, Integer>  {
	
	

}
