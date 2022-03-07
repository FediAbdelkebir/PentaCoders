package pidev.spring.service;

import java.util.List;

import pidev.spring.entities.LikeArticle;

public interface ILikeArticle {
	public String addLike(LikeArticle l,Long idArticle,Long idUser);
	
}
