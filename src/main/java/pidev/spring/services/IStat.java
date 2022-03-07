package pidev.spring.services;

public interface IStat {
	
	//Review
	int nbreReviewByUser(Long idUser);
	int nbreReviewTypeCompany();
	int nbreReviewTypeEmplyee();
	int nbreReviewTypePublic();
	int nbreReviewTypeAnnonyme();
	
	//Survey
	int nbreSurveyByUser(Long idUser);
	int nbreQuestionBySurveyAnswer(int surveyAnswer);
	
}
