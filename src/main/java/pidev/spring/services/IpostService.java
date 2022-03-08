package pidev.spring.services;

import java.util.List;

import pidev.spring.entities.Article;
import pidev.spring.entities.Post;

public interface IpostService { 
	
	      Post AjouterPost(Post c, Long idUser);  
	      Post UpdatePost(Post c, Long idUser); 
		  List<Post> retrieveAllPosts(); 
		  List<Post> retrieveByDateAsc(); 
		  List<Post> retrieveByDateDesc();
		  Post retrievePost(int id); 
		  void deletePost(int id); 
	    //CentreCommercial ajouCentre(CentreCommercial centre); 
		//CentreCommercial updateCentre(CentreCommercial c);
		//List<CentreCommercial> retrieveAllCentres(); 
		//CentreCommercial retrieveCentre(Long id);
		//void deleteCentre(Long id); 
}
