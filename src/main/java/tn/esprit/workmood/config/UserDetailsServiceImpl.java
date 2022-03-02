package tn.esprit.workmood.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.workmood.entities.Role;
import tn.esprit.workmood.entities.User;
import tn.esprit.workmood.services.UserServiceInt;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserServiceInt userService;
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
	User user = userService.findUserByUsername(userName);
	List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
	return new org.springframework.security.core.userdetails.User(user.getUsername(),
	user.getPasswd(),user.isEnabled(), true, true, true, authorities); }
	
	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for (Role role : userRoles) {
		roles.add(new SimpleGrantedAuthority(role.getName().toString())); }
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
		return grantedAuthorities;
		}

}
