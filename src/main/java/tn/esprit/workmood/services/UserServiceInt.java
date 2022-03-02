package tn.esprit.workmood.services;

import tn.esprit.workmood.entities.User;

public interface UserServiceInt {
	
	User findUserByUsername(String username);

	void save(User user);
	public void addRole(User user , Long idRole);

	void deleteUser(Long id);
	

}
