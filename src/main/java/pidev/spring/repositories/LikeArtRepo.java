package pidev.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pidev.spring.entities.Article;
import pidev.spring.entities.LikeArticle;
import pidev.spring.entities.User; 

@Repository
public interface LikeArtRepo extends JpaRepository<LikeArticle, Long> {
     
	<Optional> LikeArticle findAllById(Long id);
	List<LikeArticle> findByUser(User u); 
	
	 List<LikeArticle> findByUserIdUser(Long idUser);
	
	//@Query("select l  from likeArticle l  where ( l.User.idUser=:firstname and l.Article.idArticle=:firstname1)")
	//public LikeArticle likeexist(@Param("firstname") Long firstname,@Param("firstname1") Long firstname1); 
	
	//nb de like par article 
	
	//@Query("SELECT count(*) FROM like_article l where (l.Article.id =:idArticle)")
	//public int nbLike(@Param ("idArticle") Long idArticle);
	
	
}
