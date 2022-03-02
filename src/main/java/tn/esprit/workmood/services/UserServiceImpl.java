package tn.esprit.workmood.services;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.workmood.entities.Role;
import tn.esprit.workmood.entities.User;
import tn.esprit.workmood.repositories.RoleRepository;
import tn.esprit.workmood.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserServiceInt{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	public User findUserByUserName(String userName) {
	return userRepository.findByUsername(userName);
	}
	
	
	/*public User saveUser(User user) {
	user.setPasswd(bCryptPasswordEncoder.encode(user.getPasswd()));
	user.setConfirmPasswd(bCryptPasswordEncoder.encode(user.getConfirmPasswd()));
	user.setEnabled(true);
	return userRepository.save(user); }*/
	
	
	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}


	@Override
	public void save(User user , Long idRole ) {
		
		Role role = roleRepository.findById(idRole).get();
		
		user.setPasswd(bCryptPasswordEncoder.encode(user.getPasswd()));
		user.setConfirmPasswd(bCryptPasswordEncoder.encode(user.getConfirmPasswd()));
		user.setEnabled(true);
		role.getUsers().add(user);
		userRepository.save(user);
		//user.setRoles(new HashSet<>(roleRepository.findAll()));
		
		
	}
	
	
	@Override
	public void deleteUser(Long id) {
		
		userRepository.deleteById(id);
	}
	@Override
	public void assignRolesToUser(Long idUser, Long idRole) {
		
		User user = userRepository.findById(idUser).get();
		Role role = roleRepository.findById(idRole).get();
		
		user.getRoles().add(role);
		userRepository.save(user);	
	}
	
	@Override
	public List<User> retrieveUsers() {
		
		return userRepository.findAll();
	}
	@Override
	public User retriveUser(String username) {
		
		return userRepository.findByUsername(username);
	}

}
