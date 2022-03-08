package pidev.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pidev.spring.entities.ReactionPost;

@Repository
public interface ReactionPostrepo extends JpaRepository<ReactionPost, Long> { 
	

}
