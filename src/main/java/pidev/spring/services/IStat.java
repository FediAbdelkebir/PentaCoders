package pidev.spring.services;

public interface IStat {
	
	/*	Reclamation */
	int nbrReclamationByUser(Long idUser);
	int nbrReclamationTypeWaiting();
	int nbrReclamationTypeProcessed();
	int nbrReclamationTypeInprogress();
	
	/* Offer */
	int nbrOfferByUser(Long idUser);
	int nbrOfferCategoryServices();
	int nbrOfferCategoryShopping();
	int nbrOfferCategoryHobbies();
	int nbrOfferCategoryTraining();
	int nbrOfferCategoryFood();
	int nbrOfferCategoryHome();
	int nbrOfferCategoryOther();
	
}
