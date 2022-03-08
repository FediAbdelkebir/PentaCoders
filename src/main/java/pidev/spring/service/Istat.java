package pidev.spring.service;

public interface Istat {
	//Article
		int nbreArticleByUser(Long idUser);
		int nbreArticleByCategoryeduc(); 
		int nbreArticleByCategoryTech(); 
		int nbreArticleByCategorySel(); 
		int nbreArticleByCategoryHealth(); 
		int nbreArticleByCategoryEnt();
		int nbreLikeByUser(Long idUser);  
	
		//int nbreLikeByUserbycat(Long idUser,Long idArticle);
		
}
