package tn.esprit.workmood.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.workmood.entities.User;
import tn.esprit.workmood.services.UserServiceInt;
import tn.esprit.workmood.validator.UserValidator;

@RestController

public class UserController {
	@Autowired
    private UserServiceInt us;
	

    @Autowired
    private UserValidator userValidator;
    
    
    
    

	
	@PostMapping(value = "/add-user/{idRole}")
	@ResponseBody
    public String registration(@RequestBody User user, BindingResult bindingResult  , @PathVariable("idRole") Long idRole) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
        	
            return "registration failed  :     "+bindingResult.getAllErrors();
        }
        us.save(user, idRole );
		return "registred";
        
	}
	@DeleteMapping("/remove-user/{user-id}")
	@ResponseBody
	public void removeUser(@PathVariable("user-id") Long id) {
		us.deleteUser(id);
		System.out.println("user removed");
	}
    
	
	
	
	@PutMapping(value="/add-role/{idUser}/{idRole}")
	@ResponseBody
	public void addRoleToUser(@PathVariable("idUser") Long idUser , @PathVariable("idRole") Long idRole){
		
		us.assignRolesToUser(idUser, idRole);
	}
	@GetMapping(value="/get-all-users")
	@ResponseBody
	List <User> getUsers(){
		
		return us.retrieveUsers();
	}
	@PutMapping(value="/get-user/{idUser}")
	@ResponseBody
	User retrieveUser(@PathParam("idUser") Long idUser ){
		
		return us.retriveUser(idUser);
	}
	

}
