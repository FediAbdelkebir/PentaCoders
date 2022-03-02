package tn.esprit.workmood.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import tn.esprit.workmood.validator.AuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
	@Autowired
	private UserDetailsService userDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable();
	http.sessionManagement().sessionCreationPolicy(null);
	http.authorizeRequests().anyRequest().permitAll();
	http.addFilter(new AuthenticationFilter(authenticationManagerBean()));
	}
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();}
		
	/*.authorizeRequests() .antMatchers("/registration").permitAll()
	.antMatchers("/remove-user/{user-id}").permitAll()
	.antMatchers("/get**}").permitAll()
	.antMatchers("/get-all-users").permitAll()
	.anyRequest()
	.authenticated()
	.and()
	.and().csrf().disable();*/

	
	}
