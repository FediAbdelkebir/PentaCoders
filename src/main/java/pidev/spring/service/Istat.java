package pidev.spring.service;

public interface Istat {
	//Article
		int nbreArticleByUser(Long idUser);
		int nbreArticleByCategoryeduc(); 
		int nbreArticleByCategoryTech(); 
		int nbreArticleByCategorySel(); 
		int nbreArticleByCategoryHealth(); 
		int nbreArticleByCategoryEnt();
		
}
