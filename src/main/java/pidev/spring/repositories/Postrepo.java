package pidev.spring.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import  pidev.spring.entities.Post;

@Repository
public interface Postrepo extends JpaRepository<Post, Integer>  {

}
