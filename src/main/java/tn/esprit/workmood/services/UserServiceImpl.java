package tn.esprit.workmood.services;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	@Override
	public User findByUsername(String username) {
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

}
