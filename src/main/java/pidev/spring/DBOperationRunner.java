package pidev.spring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pidev.spring.entities.Name;
import pidev.spring.entities.Role;
import pidev.spring.entities.SurveyAnswer;
import pidev.spring.repositories.AnswersRepository;
import pidev.spring.repositories.RoleRepository;

@Component
public class DBOperationRunner implements CommandLineRunner {

    @Autowired
    AnswersRepository eRepo;
    @Autowired
    RoleRepository rr;
    @Override
    public void run(String... args) throws Exception {
    	Role R1 = new Role();
    	R1.setName(Name.ADMIN);
    	Role R2 = new Role();
    	R2.setName(Name.MANAGER);
    	Role R3 = new Role();
    	R3.setName(Name.EMPLOYEE);
          eRepo.saveAll(Arrays.asList(

                     new SurveyAnswer(1,"VERYBAD"),
                     new SurveyAnswer(2,"BAD"),
                     new SurveyAnswer(3,"GOOD"),
                     new SurveyAnswer(4,"VERYGOOD"),
                     new SurveyAnswer(5,"EXCELLENT")));
                     
        		  System.out.println("----------All Data saved into Database----------------------");
        		  
                  rr.saveAll(Arrays.asList(
                		  R1,R2,R3
                          ));
                          
             		  System.out.println("----------All Data saved into Database----------------------");
        		  
    }
    

}
