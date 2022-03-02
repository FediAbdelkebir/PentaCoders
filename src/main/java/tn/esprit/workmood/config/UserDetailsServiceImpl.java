package tn.esprit.workmood.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.workmood.entities.User;
import tn.esprit.workmood.services.UserServiceInt;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserServiceInt userService;
	@Override
	@Transactional
    @ResponseBody
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
	User user = userService.findUserByUsername(userName);
	if(user==null){
		System.out.println("User not found");
		throw new UsernameNotFoundException("User not found");
	}else{
		System.out.println("User found");
	}
	List<SimpleGrantedAuthority> authorities = new ArrayList<>();
	user.getRoles().forEach(role ->{
		authorities.add(new SimpleGrantedAuthority(role.getName().toString()));
	});
	return new org.springframework.security.core.userdetails.User(user.getUsername(),
	user.getPasswd(),user.isEnabled(), true, true, true, authorities); }
	
	/*private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for (Role role : userRoles) {
		roles.add(new SimpleGrantedAuthority(role.getName().toString())); }
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
		return grantedAuthorities;
		}*/

}
