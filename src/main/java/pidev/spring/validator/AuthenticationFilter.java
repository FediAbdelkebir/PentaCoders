package pidev.spring.validator;

import java.io.IOException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.memory.UserAttributeEditor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;


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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		log.info("username is :{}" ,username); 
		log.info("password is :{}",password);
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
				.withExpiresAt(new Date(System.currentTimeMillis()+60 * 60 * 1000))
				.withIssuer(request.getRequestURI().toString())
				.withClaim("roles" , user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.sign(algorithm);
		/*String refreshToken = JWT.create()
				.withSubject(user.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis()+30 * 60 * 1000))
				.withIssuer(request.getRequestURI().toString())
				.sign(algorithm);*/
		/*response.setHeader("access-token", accessToken);
		response.setHeader("refresh-token", refreshToken);*/
		Map<String , String> tokens = new HashMap<>();
		tokens.put("access-token", accessToken);
		/*tokens.put("refresh-token", refreshToken);*/
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		new ObjectMapper().writeValue(response.getOutputStream(),tokens);
		
				
	}
	

}
