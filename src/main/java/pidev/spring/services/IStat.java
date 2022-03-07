package pidev.spring.services;

public interface IStat {
	
	/*	Reclamation */
	int nbrReclamationByUser(Long idUser);
	int nbrReclamationTypeWaiting();
	int nbrReclamationTypeProcessed();
	int nbrReclamationTypeInprogress();
	
	/* Offer */
	
}
