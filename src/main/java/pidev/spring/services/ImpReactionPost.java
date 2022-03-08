package pidev.spring.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pidev.spring.entities.Article;
import pidev.spring.entities.LikeArticle;
import pidev.spring.entities.Post;
import pidev.spring.entities.ReactionPost;
import pidev.spring.entities.User;
import pidev.spring.repositories.Articlerepo;
import pidev.spring.repositories.LikeArtRepo;
import pidev.spring.repositories.Postrepo;
import pidev.spring.repositories.ReactionPostrepo;
import pidev.spring.repositories.UserRepository;

@Service
public class ImpReactionPost implements IreactionService { 
	
	@Autowired
	ReactionPostrepo reactionPostrepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	Postrepo postrepo; 
	
	@Override
	public String addReaction(ReactionPost l, int idPost, Long idUser) {
		// TODO Auto-generated method stub 
		int x=0;
		User u = userRepo.findById(idUser).orElse(null);
		Post p = postrepo.findById(idPost).orElse(null);
		List<ReactionPost> like = reactionPostrepo.findAll();
		for (ReactionPost la : like) { 
			
			if 
			(la.getPost().getIdPost()==(idPost)
					&& (la.getUser().getIdUser()==(idUser)))
			{
				//
				x=1;
			}

		}
			
		
		if(x==1)
			{ return "user a déja reacté cette pub";}
		else { 
			//System.out.println("test article : " + la.getArticle().getIdArticle()+", idAticle : "+idArticle);
			//System.out.println("test user : "+ la.getUser().getIdUser() + ", idUser "+ idUser+ " .."+ la.getUser().getIdUser().equals(idUser));
			
			
			l.setUser(u);
			l.setPost(p); 
			reactionPostrepo.save(l); 
			p.setNbLike(p.getNbLike()+1); 
			postrepo.save(p);
			return "User add a reaction";

		}
			}

	@Override
	public List<ReactionPost> retrieveAllReaction() {
		// TODO Auto-generated method stub
		List<ReactionPost> likees = (List<ReactionPost>) reactionPostrepo.findAll();
		return likees;
	
	}


}
