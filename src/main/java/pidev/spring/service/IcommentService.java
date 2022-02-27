package pidev.spring.service;

import java.util.List;

import pidev.spring.entities.Comment;


public interface IcommentService {
   
    Comment AjouterComm(Comment c,Long idUser);  
    Comment UpdateComm(Comment c, Long idUser); 
	  List<Comment> retrieveAllComm(); 
	  Comment retrieveComm(Long id); 
	  void deleteComm(Long id); 
}
