package tn.esprit.workmood.services;

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
	public User saveUser(User user) {
	user.setPasswd(bCryptPasswordEncoder.encode(user.getPasswd()));
	user.setEnabled(true);
	return userRepository.save(user); }
	
	
	
	
	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}


	@Override
	public void save(User user) {
		//user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		//user.setRoles(new HashSet<>(roleRepository.findAll()));
		userRepository.save(user);
	}
	public void addRole(User user , Long idRole){
		Role role = roleRepository.findById(idRole).orElse(null);
		userRepository.save(user);
		user.getRoles().add(role);
		userRepository.save(user);
	}
	
	@Override
	public void deleteUser(Long id) {
		
		userRepository.deleteById(id);
	}

}
