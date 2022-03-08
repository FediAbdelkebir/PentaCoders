package pidev.spring.services;

import java.util.List;

import  pidev.spring.entities.Name;
import  pidev.spring.entities.Role;
import  pidev.spring.entities.User;

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
	String deleteAllUsers();
	User disableAccount(Long id);
	

}
