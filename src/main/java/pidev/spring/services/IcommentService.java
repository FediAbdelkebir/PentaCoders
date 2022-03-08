package pidev.spring.services;

import java.util.List;

import pidev.spring.entities.Comment;


public interface IcommentService {
   
    Comment AjouterCommInPost(Comment c,Long idUser, int idPost); 
    Comment AjouterCommInArticle(Comment c,Long idUser, Long idArticle);
    Comment UpdateCommInPost(Comment c, Long idUser,int idPost); 
    Comment UpdateCommInArticle(Comment c, Long idUser,Long idArticle); 
	  List<Comment> retrieveAllComm(); 
	  Comment retrieveComm(Long id); 
	  void deleteComm(Long id); 
}
