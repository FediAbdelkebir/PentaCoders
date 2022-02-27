package pidev.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pidev.spring.entities.Comment;
import pidev.spring.entities.User;
import pidev.spring.repositories.Commentrepo;
import pidev.spring.repositories.UserRepo;

@Service
public class ImpCommentService implements IcommentService { 
	
	@Autowired 
	Commentrepo commentrepo; 
	@Autowired 
	UserRepo userRepo; 

	@Override
	public Comment AjouterComm(Comment c, Long idUser) {
		// TODO Auto-generated method stub 
		User u =userRepo.findById(idUser).orElse(null); 
		c.setUser(u);
		return commentrepo.save(c); 
	}

	@Override
	public Comment UpdateComm(Comment c, Long idUser) {
		// TODO Auto-generated method stub 
		User u =userRepo.findById(idUser).orElse(null); 
		c.setUser(u);
		return commentrepo.save(c); 
	}

	@Override
	public List<Comment> retrieveAllComm() {
		List<Comment> comments= (List<Comment>) commentrepo.findAll();
		return  comments; 
	}

	@Override
	public Comment retrieveComm(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteComm(Long id) {
		// TODO Auto-generated method stub 
		commentrepo.deleteById(id);
		
	}

	

}
