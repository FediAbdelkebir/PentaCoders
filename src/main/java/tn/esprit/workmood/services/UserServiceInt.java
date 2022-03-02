package tn.esprit.workmood.services;

import java.util.List;

import tn.esprit.workmood.entities.Role;
import tn.esprit.workmood.entities.User;

public interface UserServiceInt {
	
	User findUserByUsername(String username);

	void save(User user , Long idRole );
	
	
	public void assignRolesToUser(Long idUser ,Long idRole );

	void deleteUser(Long id);
	
	List<User> retrieveUsers();
	

}
