package pidev.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pidev.spring.entities.Article;
import pidev.spring.entities.LikeArticle; 

@Repository
public interface LikeArtRepo extends JpaRepository<LikeArticle, Long> {
     
	<Optional> LikeArticle findAllById(Long id);
	
	//@Query("select l  from likeArticle l  where ( l.User.idUser=:firstname and l.Article.idArticle=:firstname1)")
	//public LikeArticle likeexist(@Param("firstname") Long firstname,@Param("firstname1") Long firstname1);
	
	
}
