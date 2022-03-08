package pidev.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pidev.spring.entities.ChatMessage;
import pidev.spring.entities.Review;

@Repository
public interface MessagerieRepository extends JpaRepository<ChatMessage, Integer>{

}
