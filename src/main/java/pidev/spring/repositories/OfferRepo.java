package pidev.spring.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pidev.spring.entities.CategoryOffer;
import pidev.spring.entities.Offer;

@Repository
public interface OfferRepo extends JpaRepository<Offer, Integer>{
	
	List<Offer> findAllByCategory(CategoryOffer category);
	List<Offer> findByUsersBadgePoint(int point);
	
	@Query("SELECT o FROM Offer o WHERE o.title LIKE CONCAT('%',:s,'%')")
	public List<Offer> searchOffer(@Param("s") String s);
	
}
