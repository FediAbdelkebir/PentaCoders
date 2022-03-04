package pidev.spring.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.DocumentException;

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
	List<Offer> retrieveByDateExpAsc();
	List<Offer> retrieveByDateExpDesc();
	List<Offer> retrieveByPointAsc();
	List<Offer> retrieveByPointDesc();
	
	List<Offer> searchOffer(String title);
	
	List<Offer> retrieveFullOffer(Long idUser);
	void getOfferAndCoupon(HttpServletResponse response, int idOffer, Long idUser) throws DocumentException, IOException ;
	
	//void reserverOffer(int idOffer,int idUser); // nbrPerso+1
	//deleteoffre avec dateExp
	//kol user yaffichilou les offers li même point que li aandou
	
}
