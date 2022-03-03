package pidev.spring.service;

import java.util.List;

import pidev.spring.entities.Comment;


public interface IcommentService {
   
    Comment AjouterCommInPost(Comment c,Long idUser); 
    Comment AjouterCommInArticle(Comment c,Long idUser);
    Comment UpdateCommInPost(Comment c, Long idUser); 
    Comment UpdateCommInArticle(Comment c, Long idUser); 
	  List<Comment> retrieveAllComm(); 
	  Comment retrieveComm(Long id); 
	  void deleteComm(Long id); 
}
