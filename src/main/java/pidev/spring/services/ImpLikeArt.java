package pidev.spring.services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pidev.spring.entities.Article;
import pidev.spring.entities.LikeArticle;
import pidev.spring.entities.User;
import pidev.spring.repositories.Articlerepo;
import pidev.spring.repositories.LikeArtRepo;
import pidev.spring.repositories.UserRepository;

@Service
public class ImpLikeArt implements ILikeArticle {

	@Autowired
	LikeArtRepo likeartrepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	Articlerepo articlerepo;

	/*
	 * @Override public String addLike(LikeArticle l,Long idArticle,Long idUser)
	 * { Article a =articlerepo.findById(idArticle); l.setArticle(article);
	 * if(a.getIdArticle()==idArticle){ int nb=0; l.setNbLike(nb+1);
	 * 
	 * articlerepo.save(l); }
	 * 
	 * return "like ajoute";
	 * 
	 * }
	 * 
	 * 
	 */
	@Override
	public String addLike(LikeArticle l, Long idArticle, Long idUser) {
		// TODO Auto-generated method stub
		int x=0;
		User u = userRepo.findById(idUser).orElse(null);
		Article a = articlerepo.findById(idArticle).orElse(null);
		/*List<LikeArticle> like = likeartrepo.findAll();
		for(LikeArticle lk : like){
			//System.out.println("test"+lk.getArticle().getIdArticle().equals(idArticle));
			if(lk.getArticle().getIdArticle().equals(idArticle)&&lk.getUser().getIdUser().equals(idUser)){
				System.out.println("like ajouté"); 
				l.setUser(u);
				l.setArticle(a);
				likeartrepo.save(l);
				
			}else{
				System.out.println("article non trouvé");
				
			}
		}
		
		return like;*/
		List<LikeArticle> like = likeartrepo.findAll();
		for (LikeArticle la : like) {
			/*if (la.getArticle().getIdArticle()==l.getArticle().getIdArticle()
					&& (la.getUser().getIdUser()==l.getUser().getIdUser()))*/
			// throw new RuntimeException("You can't cancel these !");
			//System.out.println("test article : " + la.getArticle().getIdArticle()+", idAticle : "+idArticle);
			//System.out.println("test user : "+ la.getUser().getIdUser() + ", idUser "+ idUser+ " .."+ la.getUser().getIdUser().equals(idUser));
			if (la.getArticle().getIdArticle().equals(idArticle)
					&& (la.getUser().getIdUser().equals(idUser)))
			{
				//
				x=1;
			}

			
			
		}
		if(x==1)
			{ return "user a déja aimé cette pub";}
		else { 
			//System.out.println("test article : " + la.getArticle().getIdArticle()+", idAticle : "+idArticle);
			//System.out.println("test user : "+ la.getUser().getIdUser() + ", idUser "+ idUser+ " .."+ la.getUser().getIdUser().equals(idUser));
			
			
			l.setUser(u);
			l.setArticle(a); 
			likeartrepo.save(l); 
			a.setNbLike(a.getNbLike()+1); 
			articlerepo.save(a);
			return "User add a like";

		}
		
			}

	@Override
	public List<LikeArticle> retrieveAllLike() {
		// TODO Auto-generated method stub 
		List<LikeArticle> likees = (List<LikeArticle>) likeartrepo.findAll();
		return likees;
	}

	@Override
	public String updateLike(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nbLike(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deletePubLike(Long id) {
		// TODO Auto-generated method stub
		likeartrepo.deleteById(id);
	}

	@Override
	public String deleteLike(Long iduser, Long idArticle) {
		// TODO Auto-generated method stub
		return null;
	}  
	
		
}
	

/*
 * public String addLike(Long idUser,Long idArticle,LikeArticle likeArticle){
 * LikeArticle la= new LikeArticle(); la=likeartrepo.likeexist(idUser,
 * idArticle); if (la==null) { likeartrepo.save(likeArticle); return
 * "save with succes"; } else if(la.isEtat()==false){ la.setEtat(true);
 * likeartrepo.save(la); } return "update with succes"; }
 * 
 */