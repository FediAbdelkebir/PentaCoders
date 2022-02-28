package pidev.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pidev.spring.entities.SurveyAnswer;
import pidev.spring.entities.SurveyQuestion;


@Repository
public interface AnswersRepository extends JpaRepository<SurveyAnswer, Integer>{
	
	
	
}
