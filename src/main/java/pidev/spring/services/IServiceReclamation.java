package pidev.spring.services;

import java.util.List;

import pidev.spring.entities.Reclamation;
import pidev.spring.entities.StatusReclamation;

public interface IServiceReclamation {
	
	List<Reclamation> retrieveAllReclamations();
	Reclamation addReclamation(Reclamation r, Long idUser);
	Reclamation updateReclamation(Reclamation r, Long idUser);
	Reclamation retrieveReclamation(int id);
	void deleteReclamation(int id);
	
	void affectUserToReclamation(int idReclamation, Long idUser);
	
	List<Reclamation> retrieveByType(StatusReclamation status);
	List<Reclamation> retrieveByCreationDateAsc();
	List<Reclamation> retrieveByCreationDateDesc();	
	
	void treatReclamation(int idReclamation, Long idUser);
	
}
