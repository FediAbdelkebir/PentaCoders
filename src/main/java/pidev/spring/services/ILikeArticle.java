package pidev.spring.services;

import java.util.List;

import pidev.spring.entities.LikeArticle;

public interface ILikeArticle {
	public String addLike(LikeArticle l,Long idArticle,Long idUser); 
	public List<LikeArticle> retrieveAllLike();
	public String updateLike(Long id);
	public int nbLike(Long id);
	void deletePubLike(Long id);
	public String deleteLike(Long iduser,Long idArticle); 
	
	
}
