package pidev.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import  pidev.spring.entities.Article;

@Repository
public interface Articlerepo extends JpaRepository<Article, Long>{

}
