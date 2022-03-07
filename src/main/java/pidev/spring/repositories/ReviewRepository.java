package pidev.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pidev.spring.entities.CategoryReview;
import pidev.spring.entities.Classification;
import pidev.spring.entities.Review;
import pidev.spring.entities.TypeReview;
import pidev.spring.entities.User;

@Repository
public interface ReviewRepository  extends JpaRepository<Review, Integer>  {
	
	List<Review> findByCategory(CategoryReview categorie);
	
	List<Review> findByReview(TypeReview review);
	
	List<Review> findByClassf(Classification classf);
	
	List<Review> findByUser(User u); 

	
	@Query("SELECT a FROM Review a WHERE a.EmployeeName LIKE CONCAT('%',:string,'%')")
	public List<Review> searchReviewEmp(@Param("string") String EmployeeName);
	
	
	@Query("SELECT a FROM Review a WHERE a.SocieteName LIKE CONCAT('%',:string,'%')")
	public List<Review> searchReviewSociete(@Param("string") String SocieteName);

}
