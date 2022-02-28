package pidev.spring.services;

import java.util.ArrayList;
import java.util.List;

import pidev.spring.entities.CategoryOffer;
import pidev.spring.entities.Offer;
import pidev.spring.entities.User;
import pidev.spring.repositories.OfferRepo;
import pidev.spring.repositories.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceOffer implements IServiceOffer{
	
	@Autowired
	OfferRepo offerRepo;
	@Autowired
	UserRepo userRepo;

	@Override
	public List<Offer> retrieveAllOffers() {
		List<Offer> offers = (List<Offer>) offerRepo.findAll();
		return offers;
	}

	@Override
	public Offer addOffer(Offer o, Long idUser) { //, MultipartFile file
		//MultipartFile file;
		//String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		//o.setImage(fileName); // à modifier
		
		
		o.getPersonsNumber();
		offerRepo.save(o);
		System.out.println(o.getIdOffer());
		User u = userRepo.findById(idUser).orElse(null);
		System.out.println(u.getIdUser());
		System.out.println(o.getIdOffer());
		o.getUsers().add(u);
		return offerRepo.save(o);
	}
	
	@Override
	public void affectUserToOffer(int idOffer, Long idUser) {
		Offer o = offerRepo.findById(idOffer).orElse(null);
		User u = userRepo.findById(idUser).orElse(null);
		//System.out.println(u.getIdUser());
		//System.out.println(o.getIdOffer());
		o.getUsers().add(u);
		offerRepo.save(o);
	}

	@Override
	public Offer updateOffer(Offer o) {
		Offer offer = offerRepo.findById(o.getIdOffer()).orElse(null);
		offer.setTitle(o.getTitle());
		offer.setDescription(o.getDescription());
		offer.setDateExp(o.getDateExp());
		offer.setCategory(o.getCategory());
		offer.setPoint(o.getPoint());
		offer.setAddress(o.getAddress());
		offer.setLimitedNumber(o.getLimitedNumber());
		offer.setImage(null); // à modifier
		return offerRepo.save(offer);
	}

	@Override
	public Offer retrieveOffer(int id) {
		return offerRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteOffer(int id) {
		offerRepo.deleteById(id);
	}
	
	
	@Override
	public List<Offer> retrieveByCategory(CategoryOffer category) {
		return offerRepo.findAllByCategory(category);
	}

	@Override
	public List<Offer> retrieveFullOffer(Long idUser) {
		List<Offer> full = new ArrayList<>();
		List<Offer> offers = offerRepo.findAll();
		for(Offer o : offers){
			if(o.getLimitedNumber() == o.getPersonsNumber()){
				full.add(o);
			}
		}
		return full;
	}
	
	

}
