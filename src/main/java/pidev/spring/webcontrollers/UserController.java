package pidev.spring.webcontrollers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import  pidev.spring.entities.User;
import  pidev.spring.services.UserServiceInt;
import  pidev.spring.validator.UserValidator;

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
	@DeleteMapping("/remove-all-users")
	@ResponseBody
	public String deleteAllusers(){
		return us.deleteAllUsers();
	}
	@PutMapping("/disable-account/{user-id}")
	@ResponseBody
	public void DisableUser(@PathVariable("user-id") Long id) {
		us.disableAccount(id);
		System.out.println("Account Disabled");
	}
	@GetMapping(value="/get-Admins")
	@ResponseBody
	int findByUserRoleAdmin(){
		return us.findByUserRoleAdmin();
	}
	@GetMapping(value="/get-Employees")
	@ResponseBody
	int findByUserRoleEmployee(){
		return us.findByUserRoleEmployee();
		}
	@GetMapping(value="/get-Managers")
	@ResponseBody
	int findByUserRoleManager()
	{
		return us.findByUserRoleManager();
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
	@GetMapping(value="/get-user-by-email")
	@ResponseBody
	User retrieveUserbyemail(@RequestParam String email ){
		
		return us.findUserByEmailAddress(email);
	}
	
	@PostMapping("/mail")
	@ResponseBody
	public ResponseEntity<?> sendMail(@RequestParam String email ) {
		
		try{
	
			User u = us.resetPasswd(email);
			if (u == null){
			return ResponseEntity.ok("user not found");
			}
			return ResponseEntity.ok("Send Successfully");
		}catch(MailException m) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(m.getMessage());
		}
	}
	
	

}
