package  pidev.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import  pidev.spring.entities.Name;
import  pidev.spring.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	
	User findByEmailAddress(String email);
	
	List <User> findByRolesName(Name name);
	
	
	

}
