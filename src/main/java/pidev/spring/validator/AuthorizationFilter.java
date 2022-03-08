package pidev.spring.validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class AuthorizationFilter extends OncePerRequestFilter {

	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if(request.getServletPath().equals("/login")){
			filterChain.doFilter(request, response);
		}else{
			String authorizationHeader = request.getHeader("Authorization");
			if(authorizationHeader != null && authorizationHeader.contains("Bearer ")){
				try{
					String token = authorizationHeader.substring("Bearer ".length());
				
				Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
				JWTVerifier verifier = JWT.require(algorithm).build();
				DecodedJWT decodeJWT = verifier.verify(token);
				String username = decodeJWT.getSubject();
				
				String[] roles = decodeJWT.getClaim("roles").asArray(String.class);
				Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
				
				for (String role : roles ){
					System.out.println(role.toString());
					authorities.add(new SimpleGrantedAuthority(role.toString()));}
			    UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(username ,null , authorities);
			    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			    filterChain.doFilter(request, response);
				
				}catch (Exception exception) {
					log.error("error logging in :{}" , exception.getMessage());
					response.setHeader("error", exception.getMessage());
					response.setStatus(403);
					//response.sendError(403);
					Map<String , String> error = new HashMap<>();
					error.put("error_message", exception.getMessage()+"hello");
					/*tokens.put("refresh-token", refreshToken);*/
					response.setContentType(MediaType.APPLICATION_JSON_VALUE);
					new ObjectMapper().writeValue(response.getOutputStream(),error);
										
				}
			}else{
				filterChain.doFilter(request, response);
			}
		}
		
	}

	

	

}
