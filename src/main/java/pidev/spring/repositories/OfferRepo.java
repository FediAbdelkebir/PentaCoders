package pidev.spring.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pidev.spring.entities.CategoryOffer;
import pidev.spring.entities.Offer;

@Repository
public interface OfferRepo extends JpaRepository<Offer, Integer>{
	
	List<Offer> findAllByCategory(CategoryOffer category);
	
}
