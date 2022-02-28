package pidev.spring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pidev.spring.entities.SurveyAnswer;
import pidev.spring.repositories.AnswersRepository;

@Component
public class DBOperationRunner implements CommandLineRunner {

    @Autowired
    AnswersRepository eRepo;

    @Override
    public void run(String... args) throws Exception {

          eRepo.saveAll(Arrays.asList(

                     new SurveyAnswer(1,"VERYBAD"),
                     new SurveyAnswer(2,"BAD"),
                     new SurveyAnswer(3,"GOOD"),
                     new SurveyAnswer(4,"VERYGOOD"),
                     new SurveyAnswer(5,"EXCELLENT")));
                     
        		  System.out.println("----------All Data saved into Database----------------------");
    }

}
