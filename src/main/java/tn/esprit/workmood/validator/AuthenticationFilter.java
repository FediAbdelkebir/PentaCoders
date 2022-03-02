package tn.esprit.workmood.validator;

import java.io.IOException;
import java.util.Date;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.mysql.cj.xdevapi.Collection;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    
	@Autowired
    AuthenticationManager authenticationManager;
    
    public AuthenticationFilter(AuthenticationManager authenticationManager){
    	this.authenticationManager = authenticationManager;
    }
    
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String username = request.getParameter(getUsernameParameter());
		String password = request.getParameter(getPasswordParameter());
		log.info("username is :{}" ,username); log.info("password is :{}",password);
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
		return authenticationManager.authenticate(authenticationToken);
		
		

	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		User user = (User)authResult.getPrincipal(); 
		//super.successfulAuthentication(request, response, chain, authResult);
		Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
		String accessToken = JWT.create()
				.withSubject(user.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis()+10 * 60 * 1000))
				.withIssuer(request.getRequestURI().toString())
				.withClaim("roles" , user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.sign(algorithm);
		String refreshToken = JWT.create()
				.withSubject(user.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis()+30 * 60 * 1000))
				.withIssuer(request.getRequestURI().toString())
				.sign(algorithm);
		response.setHeader("access-token", accessToken);
		response.setHeader("refresh-token", refreshToken);
				
	}
	

}
