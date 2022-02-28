package tn.esprit.workmood.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import tn.esprit.workmood.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);

}
