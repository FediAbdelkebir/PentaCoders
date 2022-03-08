package tn.esprit.workmood.services;

import java.util.List;

import tn.esprit.workmood.entities.Name;
import tn.esprit.workmood.entities.Role;
import tn.esprit.workmood.entities.User;

public interface UserServiceInt {
	
	User findUserByUsername(String username);
	User findUserByEmailAddress(String email);
	

	void save(User user , Long idRole );
	
	
	public void assignRolesToUser(Long idUser ,Long idRole );

	void deleteUser(Long id);
	
	List<User> retrieveUsers();
	User retriveUser(Long idUser);
	
	User resetPasswd(String email);
	int findByUserRoleAdmin();
	int findByUserRoleEmployee();
	int findByUserRoleManager();
	

}
