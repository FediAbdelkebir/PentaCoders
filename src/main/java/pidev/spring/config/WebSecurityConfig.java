package  pidev.spring.config;

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
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import lombok.RequiredArgsConstructor;
import  pidev.spring.validator.AuthenticationFilter;
import  pidev.spring.validator.AuthorizationFilter;

//@Configuration
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
	
	private static final String[] AUTH_LIST = {
	        // -- swagger ui
			"/swagger-ui",
	        "/swagger-resources/",
	        "/swagger-ui.html",
	        "/v2/api-docs",
	        "/webjars/**"
	};
	@Bean
	public BasicAuthenticationEntryPoint swaggerAuthenticationEntryPoint() {
	    BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
	    entryPoint.setRealmName("Swagger Realm");
	    
	    return entryPoint;
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
    AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManagerBean()) ;
    authenticationFilter.setFilterProcessesUrl("/login");
    http.authorizeRequests().antMatchers(AUTH_LIST).authenticated().and()
    .httpBasic().authenticationEntryPoint(swaggerAuthenticationEntryPoint());
    
   
    
    
    
	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	//POST Methods
	//http.authorizeRequests().anyRequest().permitAll();
	
//	http.authorizeRequests().antMatchers(HttpMethod.POST ,"/login/**").permitAll();
//	http.authorizeRequests().antMatchers(HttpMethod.GET ,"/swagger-ui/**").permitAll();
//	http.authorizeRequests().antMatchers(HttpMethod.POST ,"/swagger-ui/**").permitAll();
//	http.authorizeRequests().antMatchers("/survey/retrieve-all-survey").permitAll();
//	http.authorizeRequests().antMatchers(HttpMethod.POST ,"/mail/**").permitAll();
//	http.authorizeRequests().antMatchers(HttpMethod.POST ,"/add-user/{idRole}/**").permitAll();
//	//http.authorizeRequests().antMatchers(HttpMethod.POST ,"/disable-account/{user-id}/**").hasAuthority("ADMIN");
	
	
	//GET Methods
//	http.authorizeRequests().antMatchers(HttpMethod.GET,"/get-user-by-email/**").hasAnyAuthority("ADMIN","EMPLOYEE");
//	http.authorizeRequests().antMatchers(HttpMethod.GET,"/get-all-users/**").hasAnyAuthority("ADMIN","EMPLOYEE");
//	http.authorizeRequests().antMatchers(HttpMethod.GET,"/get-Admins/**").hasAuthority("ADMIN");
//	http.authorizeRequests().antMatchers(HttpMethod.GET,"/get-Employees/**").hasAuthority("ADMIN");
//	http.authorizeRequests().antMatchers(HttpMethod.GET,"/get-Managers/**").hasAuthority("ADMIN");
	 
	//DELETE Methods
//	http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/remove-user/**").hasAnyAuthority("MANAGER","ADMIN");
	
	
//	http.authorizeRequests().anyRequest().authenticated();
	http.authorizeRequests().anyRequest().permitAll();
	
//	http.addFilter(authenticationFilter);
//	http.addFilterBefore(new AuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

	http.csrf().disable();
	
	}
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();}
		
	

	
	}
