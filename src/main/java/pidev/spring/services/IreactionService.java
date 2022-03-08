package pidev.spring.services;

import java.util.List;

import pidev.spring.entities.LikeArticle;
import pidev.spring.entities.ReactionPost;

public interface IreactionService {
  
	public String addReaction(ReactionPost l,int idPost,Long idUser); 
	public List<ReactionPost> retrieveAllReaction();
}
