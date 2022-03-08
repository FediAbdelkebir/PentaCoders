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
	//Review
		int nbreReviewByUser(Long idUser);
		int nbreReviewTypeCompany();
		int nbreReviewTypeEmplyee();
		int nbreReviewTypePublic();
		int nbreReviewTypeAnnonyme();
		
		//Survey
		int nbreSurveyByUser(Long idUser);
		int nbreQuestionBySurveyAnswer(int surveyAnswer); 
		
		//article 
		int nbreArticleByUser(Long idUser);
        int nbreArticleByCategoryeduc(); 
        int nbreArticleByCategoryTech(); 
        int nbreArticleByCategorySel(); 
        int nbreArticleByCategoryHealth(); 
        int nbreArticleByCategoryEnt();
        int nbreLikeByUser(Long idUser);
	
}
