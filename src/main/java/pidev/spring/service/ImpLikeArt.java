package pidev.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pidev.spring.entities.Article;
import pidev.spring.entities.LikeArticle;
import pidev.spring.repositories.Articlerepo;
import pidev.spring.repositories.LikeArtRepo;
import pidev.spring.repositories.UserRepo; 

@Service
public class ImpLikeArt implements ILikeArticle { 
	
	@Autowired 
	LikeArtRepo likeartrepo; 
	@Autowired 
	UserRepo userRepo; 
	@Autowired 
	Articlerepo articlerepo;
/*
	@Override
	public String addLike(LikeArticle l,Long idArticle,Long idUser) {
		Article a =articlerepo.findById(idArticle); 
		l.setArticle(article); 
		if(a.getIdArticle()==idArticle){
			int nb=0; 
			l.setNbLike(nb+1); 
			
			articlerepo.save(l);
		}
		 
		return "like ajoute";
			
		}
		

	*/
	@Override
	public String addLike(LikeArticle l, Long idArticle, Long idUser) {
		// TODO Auto-generated method stub
		return null;
	}	
	}
	/*
	public String addLike(Long idUser,Long idArticle,LikeArticle likeArticle){
		LikeArticle la= new LikeArticle();
		la=likeartrepo.likeexist(idUser, idArticle);
		if (la==null)
		{
			likeartrepo.save(likeArticle);
		return "save with succes";
		}
		else if(la.isEtat()==false){
			la.setEtat(true);
			likeartrepo.save(la);
		}
		return "update with succes";
	}
	
	*/
	
	

