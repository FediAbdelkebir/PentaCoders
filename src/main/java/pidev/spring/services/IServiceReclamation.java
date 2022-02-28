package pidev.spring.services;

import java.util.List;

import pidev.spring.entities.Reclamation;
import pidev.spring.entities.StatusReclamation;

public interface IServiceReclamation {
	
	List<Reclamation> retrieveAllReclamations(Long idUser);
	Reclamation addReclamation(Reclamation r, Long idUser);
	Reclamation updateReclamation(Reclamation r, Long idUser);
	Reclamation retrieveReclamation(int id, Long idUser);
	void deleteReclamation(int id, Long idUser);
	
	void affectUserToReclamation(int idReclamation, Long idUser);
	
	List<Reclamation> retrieveByType(StatusReclamation status, Long idUser);
	List<Reclamation> retrieveByCreationDateAsc();
	List<Reclamation> retrieveByCreationDateDesc();	
	
	void treatReclamation(int idReclamation, Long idUser);
	
	List<Reclamation> retrieveAllReclamationsByKeyword(String keyword, Long idUser);
}
