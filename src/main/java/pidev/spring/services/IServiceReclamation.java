package pidev.spring.services;

import java.util.List;

import pidev.spring.entities.Reclamation;
import pidev.spring.entities.StatusReclamation;

public interface IServiceReclamation {
	
	List<Reclamation> retrieveAllReclamations(Long idUser);
	Reclamation addReclamation(Reclamation r, Long idUser);
	//Reclamation updateReclamation(Reclamation r, Long idUser);
	Reclamation retrieveReclamation(int id, Long idUser);
	void deleteReclamation(int id, Long idUser);
	
	void affectUserToReclamation(int idReclamation, Long idUser);
	
	List<Reclamation> retrieveByType(StatusReclamation status, Long idUser);
	List<Reclamation> retrieveByCreationDateAsc();
	List<Reclamation> retrieveByCreationDateDesc();	
	List<Reclamation> retrieveByProcessingDateAsc();
	List<Reclamation> retrieveByProcessingDateDesc();
	List<Reclamation> retrieveAllReclamationsByKeyword(String keyword, Long idUser);
	
	void treatReclamation(int idReclamation, Long idUser);
	List<Reclamation> retrieveReclamationsByUser(Long idUser);
	
	int nbrReclamationByUser(Long idUser);
	int nbrReclamationTypeWaiting(Long idUser);
	int nbrReclamationTypeProcessed(Long idUser);
	int nbrReclamationTypeInprogress(Long idUser);
	
}
