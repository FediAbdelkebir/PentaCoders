package pidev.spring.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pidev.spring.entities.Article;
import pidev.spring.entities.Post;
import pidev.spring.entities.User;
import pidev.spring.repositories.Postrepo;
import pidev.spring.repositories.UserRepository;
@Service
public class ImpPostService implements IpostService { 
	
	@Autowired 
	Postrepo postrepo;  
	@Autowired 
	UserRepository userRepo;

	@Override
	public Post AjouterPost(Post c , Long idUser) {
		// TODO Auto-generated method stub 
		User u =userRepo.findById(idUser).orElse(null); 
		c.setUser(u);
		return postrepo.save(c); 
		
	}

	@Override
	public Post UpdatePost(Post c, Long idUser) {
		// TODO Auto-generated method stub 
		User u =userRepo.findById(idUser).orElse(null); 
		c.setUser(u);
		return postrepo.save(c);
	}

	@Override
	public List<Post> retrieveAllPosts() {
		List<Post> postes= (List<Post>) postrepo.findAll();
		return  postes;
	}

	@Override
	public Post retrievePost(int id) {
		// TODO Auto-generated method stub
		return postrepo.findById(id).orElse(null);
	}



	@Override
	public void deletePost(int id) {
		// TODO Auto-generated method stub 
		postrepo.deleteById(id);
		
	}

	@Override
	public List<Post> retrieveByDateAsc() {
		// TODO Auto-generated method stub
		return postrepo.findByOrderByTimeCreationAsc() ;
	}

	@Override
	public List<Post> retrieveByDateDesc() {
		// TODO Auto-generated method stub
		return postrepo.findByOrderByTimeCreationDesc();
	}

	

	//@Override
	//public Post retrievePost(Long id) {
		// TODO Auto-generated method stub
		//return postrepo.findById(id).orElse(null);
	//}

//	@Override
	//public void deleteCentre(Long id) {
		// TODO Auto-generated method stub 
		//postrepo.deleteById(id);
		
	//}

	

}
