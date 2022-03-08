package pidev.spring.repositories;


import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import  pidev.spring.entities.Post;



@Repository
public interface Postrepo extends JpaRepository<Post, Integer>  {  
	
	public List<Post> findByOrderByTimeCreationAsc(); 
	public List<Post> findByOrderByTimeCreationDesc();
   // @Query("SELECT a FROM Article a WHERE a.title LIKE CONCAT('%',:string,'%')")
	// public List<Post> searchTitle(@Param("string") String title); 

}
