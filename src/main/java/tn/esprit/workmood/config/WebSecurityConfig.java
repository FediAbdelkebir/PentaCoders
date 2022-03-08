package tn.esprit.workmood.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;
import tn.esprit.workmood.validator.AuthenticationFilter;
import tn.esprit.workmood.validator.AuthorizationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
	@Autowired
	private UserDetailsService userDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
    AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManagerBean()) ;
    authenticationFilter.setFilterProcessesUrl("/login");
    
    
   
    
	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
	http.authorizeRequests().antMatchers(HttpMethod.POST ,"/login/**").permitAll();
	http.authorizeRequests().antMatchers(HttpMethod.POST ,"/mail/**").permitAll();
	http.authorizeRequests().antMatchers(HttpMethod.POST ,"/add-user/{idRole}/**").permitAll();
	
	http.authorizeRequests().antMatchers(HttpMethod.GET,"/get-user-by-email/**").hasAnyAuthority("ADMIN","EMPLOYEE");
	http.authorizeRequests().antMatchers(HttpMethod.GET,"/get-all-users/**").hasAnyAuthority("ADMIN","EMPLOYEE");
	
	
	http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/remove-user/**").hasAnyAuthority("MANAGER","ADMIN");
	
	
	 http.authorizeRequests().anyRequest().authenticated();
	//http.authorizeRequests().anyRequest().permitAll();
	
	http.addFilter(authenticationFilter);
	http.addFilterBefore(new AuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	http.csrf().disable();
	
	}
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();}
		
	

	
	}