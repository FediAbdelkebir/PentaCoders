package pidev.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pidev.spring.entities.ArticleCategory;
import pidev.spring.repositories.Articlerepo;
import pidev.spring.repositories.LikeArtRepo;
import pidev.spring.repositories.UserRepo;

@Service
public class Stat implements Istat { 
	
	@Autowired 
	Articlerepo articlerepo;
	@Autowired 
	UserRepo userRepo; 
	@Autowired 
	LikeArtRepo likeRepo;
	
	@Override
	public int nbreArticleByUser(Long idUser) {
		// TODO Auto-generated method stub
		return articlerepo.findByUserIdUser(idUser).size();
	}  
	
	@Override
	public int nbreLikeByUser(Long idUser) {
		// TODO Auto-generated method stub
		return likeRepo.findByUserIdUser(idUser).size();
	} 
	
	


	@Override
	public int nbreArticleByCategoryeduc() {
		// TODO Auto-generated method stub
		return articlerepo.findByCategory(ArticleCategory.Education).size();
	}

	

	@Override
	public int nbreArticleByCategoryTech() {
		// TODO Auto-generated method stub
		return articlerepo.findByCategory(ArticleCategory.Technology).size();
	}

	
		
		
	@Override
	public int nbreArticleByCategoryHealth() {
		// TODO Auto-generated method stub
		return articlerepo.findByCategory(ArticleCategory.Health).size();
	}

	@Override
	public int nbreArticleByCategoryEnt() {
		// TODO Auto-generated method stub
		return articlerepo.findByCategory(ArticleCategory.Entertainment).size();
	}

	@Override
	public int nbreArticleByCategorySel() {
		// TODO Auto-generated method stub
		return articlerepo.findByCategory(ArticleCategory.Selfdeveolpment).size();
	}



	
	//public int nbreLikeByUserbycat(Long idUser) {
		// TODO Auto-generated method stub
		//return likeRepo.findByUserIdUserAndArticleCategory(idUser);
	//} 


	
}
