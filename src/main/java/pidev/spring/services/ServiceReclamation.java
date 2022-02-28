package pidev.spring.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pidev.spring.entities.Reclamation;
import pidev.spring.entities.StatusReclamation;
import pidev.spring.entities.User;
import pidev.spring.repositories.ReclamationRepo;
import pidev.spring.repositories.UserRepo;

@Service
public class ServiceReclamation implements IServiceReclamation{

	@Autowired
	ReclamationRepo reclamationRepo;
	@Autowired
	UserRepo userRepo;
	
	@Override
	public List<Reclamation> retrieveAllReclamations(Long idUser) {
		List<Reclamation> reclamations = (List<Reclamation>) reclamationRepo.findAll();
		return reclamations;
	}

	@Override
	public Reclamation addReclamation(Reclamation r, Long idUser) {
		r.setStatus(StatusReclamation.WAITING);
		r.setProcessingDate(null);
		r.setResponse(null);
		User u = userRepo.findById(idUser).orElse(null);
		r.setUser(u);
		return reclamationRepo.save(r);
	}

	@Override
	public Reclamation updateReclamation(Reclamation r, Long idUser) {
		Reclamation reclamation = reclamationRepo.findById(r.getIdReclamation()).orElse(null);
		reclamation.setObjet(r.getObjet());
		reclamation.setMessage(r.getMessage());
		reclamation.setCreationDate(r.getCreationDate());
		User u = userRepo.findById(idUser).orElse(null);
		reclamation.setUser(u);
		return reclamationRepo.save(reclamation);
	}

	@Override
	public Reclamation retrieveReclamation(int id, Long idUser) {
		Reclamation r = reclamationRepo.findById(id).orElse(null);
		r.setStatus(StatusReclamation.INPROGRESS);
		r.setProcessingDate(null);
		r.setResponse(null);
		reclamationRepo.save(r);
		return reclamationRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteReclamation(int id, Long idUser) {
		reclamationRepo.deleteById(id);
	}
	
	@Override
	public void affectUserToReclamation(int idReclamation, Long idUser) {
		Reclamation r = reclamationRepo.findById(idReclamation).orElse(null);
		User u = userRepo.findById(idUser).orElse(null);
		r.setUser(u);
		reclamationRepo.save(r);
	}
	
	@Override
	public List<Reclamation> retrieveByType(StatusReclamation status, Long idUser) {
		return reclamationRepo.findAllByStatus(status);
	}

	@Override
	public List<Reclamation> retrieveByCreationDateAsc() {
		return reclamationRepo.findByOrderByCreationDateAsc();
	}

	@Override
	public List<Reclamation> retrieveByCreationDateDesc() {
		return reclamationRepo.findByOrderByCreationDateDesc();
	}

	@Override
	public void treatReclamation(int idReclamation, Long idUser) {
		Reclamation reclamation = reclamationRepo.findById(idReclamation).orElse(null);
		reclamation.setStatus(StatusReclamation.PROCESSED);
		reclamation.setProcessingDate(new Date());
		reclamation.setResponse("response of reclamation");
		reclamationRepo.save(reclamation);
		// notifier l'user, envoyer mail
	}

	@Override
	public List<Reclamation> retrieveAllReclamationsByKeyword(String keyword, Long idUser) { 
		return (List<Reclamation>) reclamationRepo.findAll();
	}
	
	
	
	
	
}
