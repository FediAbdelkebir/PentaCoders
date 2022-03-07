package pidev.spring.services;

import org.springframework.beans.factory.annotation.Autowired;

import pidev.spring.entities.StatusReclamation;
import pidev.spring.repositories.OfferRepo;
import pidev.spring.repositories.ReclamationRepo;
import pidev.spring.repositories.UserRepo;

public class Stat implements IStat{
	
	@Autowired
	ReclamationRepo reclamationRepo;
	@Autowired
	UserRepo userRepo;
	@Autowired
	OfferRepo offerRepo;

	@Override
	public int nbrReclamationByUser(Long idUser){
		return reclamationRepo.findByUserIdUser(idUser).size();
	}

	@Override
	public int nbrReclamationTypeWaiting() {
		return reclamationRepo.findAllByStatus(StatusReclamation.WAITING).size();
	}

	@Override
	public int nbrReclamationTypeProcessed() {
		return reclamationRepo.findAllByStatus(StatusReclamation.PROCESSED).size();
	}

	@Override
	public int nbrReclamationTypeInprogress() {
		return reclamationRepo.findAllByStatus(StatusReclamation.INPROGRESS).size();
	}

}
