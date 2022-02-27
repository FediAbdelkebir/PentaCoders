package pidev.spring.services;

import java.util.List;

import pidev.spring.entities.CategoryOffer;
import pidev.spring.entities.Offer;

public interface IServiceOffer {
	
	List<Offer> retrieveAllOffers();
	Offer addOffer(Offer o, Long idUser);
	Offer updateOffer(Offer o);
	Offer retrieveOffer(int id);
	void deleteOffer(int id);
	
	void affectUserToOffer(int idOffer, Long idUser);
	List<Offer> retrieveByCategory(CategoryOffer category);
	
	void retrieveFullOffer(Long idUser);
	
}
