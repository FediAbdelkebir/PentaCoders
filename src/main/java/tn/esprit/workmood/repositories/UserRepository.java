package tn.esprit.workmood.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.workmood.entities.Name;
import tn.esprit.workmood.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	
	User findByEmailAddress(String email);
	
	List <User> findByRolesName(Name name);
	

}
