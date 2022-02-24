package pidev.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pidev.spring.entities.SurveyQuestion;

@Repository
public interface SurveyRepository  extends JpaRepository<SurveyQuestion, Integer>  {
	
	

}
